package exercise;

import java.util.Scanner;

public class Factorial {
	
	public static int toFactorial(int num)
	{
		int result=1;
		for(int i=1;i<=num;i++)
		{
			result=result*i;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap so: ");
		int num=sc.nextInt();
		
		System.out.print(num+"! ="+toFactorial(num));
		
		
		sc.close();
	}

}
