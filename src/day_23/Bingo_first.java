package day_23;

import java.util.Scanner;
import java.util.Random;

public class Bingo_first {
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
		
		int p1x = 0;		int p1y = 0;
		int p2x = 0;		int p2y = 0;
		int win1 = 0;		int win2 = 0;
		int turn = 0;
		
		while(true)
		{	
			for(int j=0;j<5;j++)					//중복되는 숫자가 없이 빙고판 완성
			{
				for(int k=0;k<5;k++)
				{
					if(Bingo[j][k] == 0)
					{
						System.out.print("[P1] ");
					}
					else if(Bingo[j][k] == 1)
					{
						System.out.print("[P2] ");
					}
				    else if(Bingo[j][k] < 10)
					{
						System.out.print("["+Bingo[j][k]+" ] ");
					}
					else
					{
						System.out.print("["+Bingo[j][k]+"] ");
					}
				}
				System.out.println();
			}
			
			if(win1 == 1)				//player1 승리
			{
				System.out.println("player 1 승리!!!");
				System.out.println("게임을 종료하겠습니다");
				break;
			}
			else if(win2 == 1)				//player2 승리
			{
				System.out.println("player 2 승리!!!");
				System.out.println("게임을 종료하겠습니다");
				break;
			}
			
			
			if(turn%2 == 0)				//player1 턴
			{
				int idx1_j=0;		int idx1_k=0;
				
				System.out.println("player1의 x좌표를 입력하여라");
				p1x = sc.nextInt();
				System.out.println("player1의 y좌표를 입력하여라");
				p1y = sc.nextInt();
				
				for(int j=0;j<5;j++)					//중복되는 숫자가 없이 빙고판 완성
				{
					for(int k=0;k<5;k++)
					{
						if(Bingo[j][k] == Bingo[p1y][p1x])
						{
							idx1_j = j;
							idx1_k = k;
						}
					}
				}
				
				Bingo[idx1_j][idx1_k] = 0;
				turn++;
				
				//만약 player1으로 고정하고 싶으면 turn값만 고정시키고 조건문 걸어줘서 특정 숫자 입력하면 다시 메뉴로 돌아가서 몇명에서 플레이 해줄것인지
				//정하게 하는 메뉴로 보내면 될 것 같은데  -> 굳이 처음부터 if문 사용하여 메뉴를 구분하여 똑같은 코드 두번 사용하면 메모리 낭비랑 효율이 떨어지지 않을까?
			}
			else if(turn%2 == 1)				//player2 턴
			{
				int idx2_j=0;		int idx2_k=0;
				
				System.out.println("player2의 x좌표를 입력하여라");
				p2x = sc.nextInt();
				System.out.println("player2의 y좌표를 입력하여라");
				p2y = sc.nextInt();
				
				for(int j=0;j<5;j++)					//중복되는 숫자가 없이 빙고판 완성
				{
					for(int k=0;k<5;k++)
					{
						if(Bingo[j][k] == Bingo[p2y][p2x])
						{
							idx2_j = j;
							idx2_k = k;
						}
					}
				}
				
				Bingo[idx2_j][idx2_k] = 1;
				turn++;
			}
			
			//<빙고가 완성 되기 위한 조건>
			
			//1) 가로 숫자 5개
			for(int j=0;j<5;j++)					
			{
				int bingo_check = 0;
				for(int k=0;k<5;k++)
				{
					if(Bingo[j][k] == 0)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win1 = 1;
				}
			}
			
			for(int j=0;j<5;j++)					
			{
				int bingo_check = 0;
				for(int k=0;k<5;k++)
				{
					if(Bingo[j][k] == 1)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win2 = 1;
				}
			}
			
			//2) 세로 숫자 5개
			for(int k=0;k<5;k++)					
			{
				int bingo_check = 0;
				for(int j=0;j<5;j++)
				{
					if(Bingo[j][k] == 0)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win1 = 1;
				}
			}
			
			for(int k=0;k<5;k++)					
			{
				int bingo_check = 0;
				for(int j=0;j<5;j++)
				{
					if(Bingo[j][k] == 1)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win2 = 1;
				}
			}
			
			//3) 대각선 2개
			int bingo_check = 0;
			for(int j=0;j<5;j++)					
			{
				for(int k=0;k<5;k++)
				{
					if(j == k && Bingo[j][k] == 0)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win1 = 1;
				}
			}
			
			bingo_check = 0;
			for(int j=0;j<5;j++)					
			{
				for(int k=0;k<5;k++)
				{
					if(j == k && Bingo[j][k] == 1)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win2 = 1;
				}
			}
			
			bingo_check = 0;
			for(int j=0;j<5;j++)					
			{
				if(Bingo[j][4-j] == 0)
				{
					bingo_check++;
				}
				
				if(bingo_check == 5)
				{
					win1 = 1;
				}
			}
			
			bingo_check = 0;
			for(int j=0;j<5;j++)					
			{
				if(Bingo[j][4-j] == 1)
				{
					bingo_check++;
				}
				
				if(bingo_check == 5)
				{
					win2 = 1;
				}
			}
			
		}
		
	}
}