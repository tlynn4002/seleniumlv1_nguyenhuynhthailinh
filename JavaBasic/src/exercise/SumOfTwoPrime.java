package exercise;

import java.util.Scanner;

public class SumOfTwoPrime {
	public static boolean isPrime(int num)
	{
		if (num<2) return false;
		for(int i=2;i<Math.sqrt(num);i++)
		{
			if(num%i==0)
				return false;
			
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap so: ");
		int num=sc.nextInt();
		
		for(int i=0;i<num/2;i++)
		{
			if(isPrime(i) && isPrime(num-i) )
			{
				System.out.print("\n"+ num+ " = "+ i + " + "+(num-i));
			}
				
		}
		sc.close();
	}

}
