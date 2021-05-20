package com.image;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.FileOutputStream;


public class ImageSimilarityComparison {

	public static  int comparison(String srcImagePath,String targetImagePath) throws  Exception{
		int scaleSize = 400; 
		int similarity =100;

		String srcTempPath="C:\\Users\\Mohamed.Nheri\\OneDrive - FDA\\Desktop\\src1.PNG";
		String targetTempPath="C:\\Users\\Mohamed.Nheri\\OneDrive - FDA\\Desktop\\target1.PNG";

		
		scaleImage(srcImagePath,srcTempPath,scaleSize,scaleSize);
		scaleImage(targetImagePath, targetTempPath, scaleSize, scaleSize);
		BufferedImage srcImage = ImageIO.read(new File(srcTempPath));
		BufferedImage targetImage = ImageIO.read(new File(targetTempPath));

		
		grayImage(srcImage);
		grayImage(targetImage);

		
		String srcCode = imageCode(srcImage);
		String targetCode = imageCode(targetImage);
	
		System.out.println(srcCode);
		System.out.println(targetCode);
		similarity = hanming(srcCode,targetCode);
		return similarity;
	}


	public static  int hanming(String str1,String str2){
		int distance = 0;
		for(int i=0;i<str1.length();i++){
				if(str1.charAt(i)  != str2.charAt(i)){
					distance++;
				}
		}
		return distance;
	}

	public static  String  imageCode(BufferedImage bufferedImage){
		int width = bufferedImage.getWidth(null);
		int height = bufferedImage.getHeight(null);

		int[][] pixels=new int[width][height];
		int total = 0;
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				pixels[i][j] = bufferedImage.getRGB(i,j) & 0xFFFFFF;
				total += pixels[i][j];
			}
		}

		int avg = total / (width * height);
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				if(pixels[i][j] < avg){
					stringBuilder.append("0");
				}else{
					stringBuilder.append("1");
				}
			}
		}

		return stringBuilder.toString();
	}

	public static void grayImage(BufferedImage bufferedImage){
		ColorConvertOp colorConvert = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
		colorConvert.filter(bufferedImage,bufferedImage);
	}

	public static void  scaleImage(String srcImagePath,String outImagePath,int width,int height) throws  Exception{
		BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.getGraphics();
		g.drawImage( ImageIO.read(new File(srcImagePath)),0,0,width,height,null);
		g.dispose();
		ImageIO.write(bi, "JPG", new FileOutputStream(outImagePath));
	}

	public static  void main(String[] args){
		String srcImage = "C:\\Users\\Mohamed.Nheri\\OneDrive - FDA\\Desktop\\1.PNG";
		String targetImage = "C:\\Users\\Mohamed.Nheri\\OneDrive - FDA\\Desktop\\2.PNG";
		int similarityNum;
		try {
			similarityNum = ImageSimilarityComparison.comparison(srcImage, targetImage);
			System.out.println(similarityNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
