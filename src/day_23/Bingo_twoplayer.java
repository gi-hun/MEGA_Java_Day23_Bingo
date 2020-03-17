package day_23;

import java.util.Scanner;
import java.util.Random;

public class Bingo_twoplayer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int[][] Bingo_player1 = new int[5][5];		//5*5 2차원 배열 생성
		int[][] Bingo_player2 = new int[5][5];		//5*5 2차원 배열 생성
		
		int[] temp_player1 = new int[25];
		int[] temp_player2 = new int[25];
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
				if(num==temp_player1[j])
				{
					check = -1;
				}
				j++;
			}
			
			if(check == 1)
			{
				temp_player1[i] = num;					//temp배열은 1-50중 중복되지 않은 숫자 25개가 들어있다
				i++;
			}
		}
		
		i = 0;
		while(i<25)			// [1] temp에 1~50사이의 랜덤 숫자 25개를 중복없이 저장(중복숫자금지)
		{
			int num = ran.nextInt(50) + 1;
			
			int check = 1;
			int j = 0;
			while(j<i)
			{
				if(num==temp_player2[j])
				{
					check = -1;
				}
				j++;
			}
			
			if(check == 1)
			{
				temp_player2[i] = num;					//temp배열은 1-50중 중복되지 않은 숫자 25개가 들어있다
				i++;
			}
		}
		
		int count = 0;
		for(int j=0;j<5;j++)
		{
			for(int k=0;k<5;k++)
			{
				Bingo_player1[j][k] = temp_player1[count];
				count++;
			}
		}
		
		count = 0;
		for(int j=0;j<5;j++)
		{
			for(int k=0;k<5;k++)
			{
				Bingo_player2[j][k] = temp_player2[count];
				count++;
			}
		}
		
		int p1y = 0;		int p1x = 0;
		int p2y = 0;		int p2x = 0;
		int win1 = 0;		int win2 = 0;
		int turn = 0;
		int idx1_j=0;		int idx1_k=0;
		int idx2_j=0;		int idx2_k=0;
		
		while(true)
		{	
			System.out.println("==========Bingo Game==========");
			System.out.println();
			System.out.println("player1 Bingo Board");
			
			for(int j=0;j<5;j++)					//중복되는 숫자가 없이 빙고판 완성
			{
				for(int k=0;k<5;k++)
				{
					if(Bingo_player1[j][k] == 0)
					{
						System.out.print("[P1] ");
					}
				    else if(Bingo_player1[j][k] < 10)
					{
						System.out.print("["+Bingo_player1[j][k]+" ] ");
					}
					else
					{
						System.out.print("["+Bingo_player1[j][k]+"] ");
					}
					
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("player2 Bingo Board");
			for(int j=0;j<5;j++)					//중복되는 숫자가 없이 빙고판 완성
			{
				for(int k=0;k<5;k++)
				{
					if(Bingo_player2[j][k] == 0)
					{
						System.out.print("[P2] ");
					}
				    else if(Bingo_player2[j][k] < 10)
					{
						System.out.print("["+Bingo_player2[j][k]+" ] ");
					}
					else
					{
						System.out.print("["+Bingo_player2[j][k]+"] ");
					}
					
				}
				System.out.println();
			}

			System.out.println();
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
				System.out.println("player1의 y좌표를 입력하여라");
				p1y = sc.nextInt();
				System.out.println("player1의 x좌표를 입력하여라");
				p1x = sc.nextInt();
				
				idx1_j = p1y;
				idx1_k = p1x;
				
				for(int j=0;j<5;j++)					//중복되는 숫자가 없이 빙고판 완성
				{
					for(int k=0;k<5;k++)
					{
						if(Bingo_player1[idx1_j][idx1_k] == Bingo_player2[j][k])
						{
							idx2_j = j;
							idx2_k = k;
							Bingo_player2[idx2_j][idx2_k] = 0;
						}
					}

				}
				Bingo_player1[idx1_j][idx1_k] = 0;
	
				turn++;
				
				//만약 player1으로 고정하고 싶으면 turn값만 고정시키고 조건문 걸어줘서 특정 숫자 입력하면 다시 메뉴로 돌아가서 몇명에서 플레이 해줄것인지
				//정하게 하는 메뉴로 보내면 될 것 같은데  -> 굳이 처음부터 if문 사용하여 메뉴를 구분하여 똑같은 코드 두번 사용하면 메모리 낭비랑 효율이 떨어지지 않을까?
			}
			else if(turn%2 == 1)				//player2 턴
			{
				System.out.println("player2의 y좌표를 입력하여라");
				p2y = sc.nextInt();
				System.out.println("player2의 x좌표를 입력하여라");
				p2x = sc.nextInt();
				
				
				idx2_j = p2y;
				idx2_k = p2x;
				
				for(int j=0;j<5;j++)					//중복되는 숫자가 없이 빙고판 완성
				{
					for(int k=0;k<5;k++)
					{	
						if(Bingo_player2[idx2_j][idx2_k] == Bingo_player1[j][k])
						{
							idx1_j = j;
							idx1_k = k;
							Bingo_player1[idx1_j][idx1_k] = 0;
						}
					}
				}
				
				Bingo_player2[idx2_j][idx2_k] = 0;
				
				turn++;
			}
			
			//<빙고가 완성 되기 위한 조건>
			
			//1) 가로 숫자 5개
			for(int j=0;j<5;j++)					
			{
				int bingo_check = 0;
				for(int k=0;k<5;k++)
				{
					if(Bingo_player1[j][k] == 0)
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
					if(Bingo_player2[j][k] == 0)
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
					if(Bingo_player1[j][k] == 0)
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
					if(Bingo_player2[j][k] == 0)
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
					if(j == k && Bingo_player1[j][k] == 0)
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
					if(j == k && Bingo_player2[j][k] == 0)
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
				if(Bingo_player1[j][4-j] == 0)
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
				if(Bingo_player2[j][4-j] == 0)
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