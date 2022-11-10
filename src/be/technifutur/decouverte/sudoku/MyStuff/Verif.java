package be.technifutur.decouverte.sudoku.MyStuff;

import java.util.Scanner;

public class Verif {
	
	public static float Input(int min, int max, float input){
		Scanner lecture = new Scanner(System.in);
		input = lecture.nextFloat();
		
		while (input < min || input > max || input % 1 != 0){
			System.out.println("Entrée incorrecte");
			input = lecture.nextFloat();			
		}
		
		return input;
	}

}
