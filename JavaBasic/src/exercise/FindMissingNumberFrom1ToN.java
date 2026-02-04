package exercise;

import java.util.Scanner;

public class FindMissingNumberFrom1ToN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Nhap chuoi so: ");
		String stringNumber=sc.nextLine();
		String[] splitNumber=stringNumber.split(" ");
		int [] arrayInput = new int[splitNumber.length]; 
		
		for(int i=0;i<splitNumber.length;i++)
		{
			arrayInput[i]=Integer.parseInt(splitNumber[i]);
		}
		
		System.out.println("Mang vua nhap:" );
		
		// set max is the first number in array input
		int max=arrayInput[0];
		for(int i=0;i<splitNumber.length;i++)
		{
			System.out.print(arrayInput[i]+" ");
			if(arrayInput[i]>max)
			{
				max=arrayInput[i];
			}
		}
		
		boolean [] check = new boolean[max+1];
		for(int i=0;i<arrayInput.length;i++)
		{
			if(arrayInput[i]>=1 && arrayInput[i]<= max)
			{
				check[arrayInput[i]]=true;
			}
		}
		System.out.println("\nSo bi thieu: ");
		for(int i=1;i<=max;i++)
		{
			if(!check[i])
			{
				System.out.print(i+" ");
			}
		}
		sc.close();
	}

}
