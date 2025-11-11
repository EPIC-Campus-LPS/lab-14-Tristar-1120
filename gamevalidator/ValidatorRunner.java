package gamevalidator;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ValidatorRunner {

	public static void main(String[] args) throws IOException{
		String[][] data = new String[10][10];
		Scanner i = new Scanner(System.in);
		System.out.print("Input: ");
		String board = i.nextLine();
		Scanner boardFile = new Scanner(new File(board));
		int r = 0;
		while (boardFile.hasNextLine()) {
			String[] temp = boardFile.nextLine().split(",");
			data[r] = temp;
		}
		boardFile.close();
		
		
		
		if (Validator.boardValidator(data)) {
			System.out.println("\nThis board is valid.");
			if (Validator.balanced(data)) {
				System.out.println("This board is balanced.");
			}
			else {
				System.out.println("This board is not balanced.");
			}
		}
		else {
			System.out.print("\nThis board is not valid.\nThis board could not be checked for balance.");
		}
			

	}

}
