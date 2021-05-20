package com.image;

import java.io.IOException;
import org.frontendtest.components.ImageComparison;



/*What it does (simplified):

    First the two images that should be compared are divided in squares with the width and height, that you defined in the constructor.
    For every square in each image an average RGB-Value is calculated.
    If the average RGB-Values of the corresponding squares differ more than the threshold that you defined in the constructor (0.05 = 5%), the function fuzzyEqual(…) 
    will return false.
    If you passed a path to save an image with the found differences a copy will be save at this path with all the differences marked with red squares.
    Note: The sensitivity of the fuzzy-equal-test will be influenced by the defined threshold as well as the size of the squares!*/

public class RunComparison {
	public static void main(String

					

						[] args) throws IOException {
		String imgOriginal = "C:\\Users\\Mohamed.Nheri\\OneDrive - FDA\\Desktop\\team.jpg";
		String imgToCompareWithOriginal = "C:\\Users\\Mohamed.Nheri\\OneDrive - FDA\\Desktop\\team1.jpg";
		String imgOutputDifferences = "new_screenshot_with_changes.jpg";
	
			ImageComparison imageComparison = new ImageComparison(10,10,0.05);
	
			if(imageComparison.fuzzyEqual(imgOriginal,imgToCompareWithOriginal,imgOutputDifferences))
			System.out.println("Images are fuzzy-equal.");
		else
			System.out.println("Images are not fuzzy-equal.");
	}
}

