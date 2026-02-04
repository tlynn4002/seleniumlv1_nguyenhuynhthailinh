package exercise;

import java.util.Scanner;

public class ConvertToPositiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Nhap so am: ");
		int input= sc.nextInt();
		System.out.println("So duong: "+Math.abs(input));
		
		sc.close();
	}

}
