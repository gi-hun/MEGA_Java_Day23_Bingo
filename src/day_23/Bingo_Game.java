//Bingo_oneplayer + Bingo_twoplayer =  Bingo_Game
package day_23;

import java.util.Scanner;
import java.util.Random;

public class Bingo_Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int[][] Bingo = new int[5][5];		//5*5 2차원 배열 생성
		
		int[] temp = new int[25];
		// [1] temp에 1~50사이의 랜덤 숫자 25개를 중복없이 저장(중복숫자금지)
		// [2] 1차원 temp의 값을 2차원 Bingo에 넣어주기
		//심화 예제 3번
		
		int i = 0;
		while(i<25)			// [1] temp에 1~50사이의 랜덤 숫자 25개를 중복없이 저장(중복숫자금지)
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
				temp[i] = num;					//temp배열은 1-50중 중복되지 않은 숫자 25개가 들어있다
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