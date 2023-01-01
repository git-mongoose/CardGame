import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.regex.Pattern;

class GameUtils {
	private static final String REGEX_ALPHABET = "^[A-Za-z]{4,12}$";
	
	private GameUtils(){}
	
	public static String getInputString() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = null;
		try {
			inputString = br.readLine();			
		} catch(IOException e) {
			System.out.println("Input error...Please retype!");
			getInputString();
		}
		return inputString;
	}
	
	public static int getInputInt() {
		int inputInt = 0;
		try {
			inputInt = Integer.parseInt(getInputString());
		} catch(NumberFormatException e) {
			System.out.println("Please enter an Integer!");
			getInputInt();
		}
		
		return inputInt;
	}
	
	public static int getRandomInt(int maxValue) {
		Random random = new Random();
		return random.nextInt(maxValue);
		
	}
	
	public static boolean checkPattern(String targetStr) {
		if (targetStr == null || targetStr.isEmpty()) {
			return false;
		} 
		return Pattern.matches(REGEX_ALPHABET, targetStr);

	}
}