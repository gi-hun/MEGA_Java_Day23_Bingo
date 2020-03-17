package day_23;

import java.util.Scanner;
import java.util.Random;

public class Bingo_first {
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
		
		int p1x = 0;		int p1y = 0;
		int p2x = 0;		int p2y = 0;
		int win1 = 0;		int win2 = 0;
		int turn = 0;
		
		while(true)
		{	
			for(int j=0;j<5;j++)					//�ߺ��Ǵ� ���ڰ� ���� ������ �ϼ�
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
			
			if(win1 == 1)				//player1 �¸�
			{
				System.out.println("player 1 �¸�!!!");
				System.out.println("������ �����ϰڽ��ϴ�");
				break;
			}
			else if(win2 == 1)				//player2 �¸�
			{
				System.out.println("player 2 �¸�!!!");
				System.out.println("������ �����ϰڽ��ϴ�");
				break;
			}
			
			
			if(turn%2 == 0)				//player1 ��
			{
				int idx1_j=0;		int idx1_k=0;
				
				System.out.println("player1�� x��ǥ�� �Է��Ͽ���");
				p1x = sc.nextInt();
				System.out.println("player1�� y��ǥ�� �Է��Ͽ���");
				p1y = sc.nextInt();
				
				for(int j=0;j<5;j++)					//�ߺ��Ǵ� ���ڰ� ���� ������ �ϼ�
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
				
				//���� player1���� �����ϰ� ������ turn���� ������Ű�� ���ǹ� �ɾ��༭ Ư�� ���� �Է��ϸ� �ٽ� �޴��� ���ư��� ����� �÷��� ���ٰ�����
				//���ϰ� �ϴ� �޴��� ������ �� �� ������  -> ���� ó������ if�� ����Ͽ� �޴��� �����Ͽ� �Ȱ��� �ڵ� �ι� ����ϸ� �޸� ����� ȿ���� �������� ������?
			}
			else if(turn%2 == 1)				//player2 ��
			{
				int idx2_j=0;		int idx2_k=0;
				
				System.out.println("player2�� x��ǥ�� �Է��Ͽ���");
				p2x = sc.nextInt();
				System.out.println("player2�� y��ǥ�� �Է��Ͽ���");
				p2y = sc.nextInt();
				
				for(int j=0;j<5;j++)					//�ߺ��Ǵ� ���ڰ� ���� ������ �ϼ�
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
			
			//<���� �ϼ� �Ǳ� ���� ����>
			
			//1) ���� ���� 5��
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
			
			//2) ���� ���� 5��
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
			
			//3) �밢�� 2��
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