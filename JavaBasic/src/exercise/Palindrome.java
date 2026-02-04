package exercise;

import java.util.Scanner;

public class Palindrome {
	public static boolean isPalindrome(String s, int left, int right)
	{
		if(left>right)
		return true;
		if(s.charAt(left)!=s.charAt(right))
			return false;
		return isPalindrome(s,left+1,right-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String s=sc.nextLine();
		
		System.out.print(isPalindrome(s,0,s.length()-1));
		
		sc.close();
	}

}
