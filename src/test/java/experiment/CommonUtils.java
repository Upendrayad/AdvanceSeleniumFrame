package experiment;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class CommonUtils {

	public static String generateBrandNewEmail() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@email.com";
	}

	/*
	 * Date date = new Date(); String dateString = date.toString(); String
	 * nospaceDateString = dateString.replaceAll(" ", ""); String
	 * nospaceNoColonDateString = nospaceDateString.replaceAll("\\:", ""); String
	 * emailString = nospaceNoColonDateString +"@gmail.com"; return emailString;
	 */

	/*
	 * public static boolean compareTwoScreenshots(String actualImagePath, String
	 * expectedImagePath) { BufferedImage acutualBImg = ImageIO.read(new
	 * File(actualImagePath)); BufferedImage expectedBImg = ImageIO.read(new
	 * File(expectedImagePath));
	 * 
	 * ImageDiffer imgDiffer = new ImageDiffer(); ImageDiff imgDifference =
	 * imgDiffer.makeDiff(expectedBImg, acutualBImg);
	 * 
	 * return imgDifference.hasDiff();
	 * 
	 * }
	 */
	public static Properties loadProperties(){
		Properties prop = new Properties();
		try {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\projectdata.properties");

			prop.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
