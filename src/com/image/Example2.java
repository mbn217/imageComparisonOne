package com.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Example2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

		
		ImageIO.write(
		        getDifferenceImage(
		                ImageIO.read(new File("C:\\Users\\Mohamed.Nheri\\OneDrive - FDA\\Desktop\\1.png")),
		                ImageIO.read(new File("C:\\Users\\Mohamed.Nheri\\OneDrive - FDA\\Desktop\\2.png"))),
		        "png",
		        new File("output.png"));
	}
	
	public static BufferedImage getDifferenceImage(BufferedImage img1, BufferedImage img2) {
	    // convert images to pixel arrays...
	    final int w = img1.getWidth(),
	            h = img1.getHeight(), 
	            highlight = Color.MAGENTA.getRGB();
	    final int[] p1 = img1.getRGB(0, 0, w, h, null, 0, w);
	    final int[] p2 = img2.getRGB(0, 0, w, h, null, 0, w);
	    // compare img1 to img2, pixel by pixel. If different, highlight img1's pixel...
	    for (int i = 0; i < p1.length; i++) {
	        if (p1[i] != p2[i]) {
	            p1[i] = highlight;
	        }
	    }
	    // save img1's pixels to a new BufferedImage, and return it...
	    // (May require TYPE_INT_ARGB)
	    final BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    out.setRGB(0, 0, w, h, p1, 0, w);
	    return out;
	}

}
