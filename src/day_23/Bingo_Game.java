//Bingo_oneplayer + Bingo_twoplayer =  Bingo_Game
package day_23;

import java.util.Scanner;
import java.util.Random;

public class Bingo_Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int[][] Bingo = new int[5][5];		//5*5 2���� �迭 ����
		
		int[] temp = new int[25];
		// [1] temp�� 1~50������ ���� ���� 25���� �ߺ����� ����(�ߺ����ڱ���)
		// [2] 1���� temp�� ���� 2���� Bingo�� �־��ֱ�
		//��ȭ ���� 3��
		
		int i = 0;
		while(i<25)			// [1] temp�� 1~50������ ���� ���� 25���� �ߺ����� ����(�ߺ����ڱ���)
		{
			int num = ran.nextInt(50) + 1;
			
			int check = 1;
			int j = 0;
			while(j<i)
			{
				if(num==temp[j])
				{
					check = -1;
				}
				j++;
			}
			
			if(check == 1)
			{
				temp[i] = num;					//temp�迭�� 1-50�� �ߺ����� ���� ���� 25���� ����ִ�
				i++;
			}
		}
		
		int count = 0;
		for(int j=0;j<5;j++)
		{
			for(int k=0;k<5;k++)
			{
				Bingo[j][k] = temp[count];
				count++;
			}
		}
		
		System.out.println("======BingoGame======");
		int menu = sc.nextInt();
		
		if(menu == 1) {}
		else if(menu == 2) {}
		else if(menu == 3) {}
	}
}