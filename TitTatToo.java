package game;

import java.util.Scanner;

public class TitTatToo {
	public static String board[]= {"0","1","2","3","4","5","6","7","8"};
	public static int player=0;
	static Scanner sc=new Scanner(System.in);
	static boolean flag=true;
	
	public static void print() 
	{
		System.out.println("\n");
		System.out.println(" |-----|-----|-----|");
		System.out.println(" |  "+board[0]+"  |  "+board[1]+"  |  "+board[2]+"  |");
		System.out.println(" |-----|-----|-----|");
		System.out.println(" |  "+board[3]+"  |  "+board[4]+"  |  "+board[5]+"  |");
		System.out.println(" |-----|-----|-----|");
		System.out.println(" |  "+board[6]+"  |  "+board[7]+"  |  "+board[8]+"  |");
		System.out.println(" |-----|-----|-----|");
		System.out.println("\n");
	}
	
	
	
	public static void getMsg() 
	{
		System.out.println(player%2==0?"player A":"player B");
		System.out.print("Enter the number where we need to place:");
		int a=sc.nextInt();
		System.out.println(insert(a,player%2==0?"X":"O"));
		
	}
	
	
	
	public static String insert(int a,String name)
	{
		if(a>=0 && a<=8)
		{
			if((!board[a].equals("X")) && (!board[a].equals("O")))
			{
				board[a]=name;
				player++;
				print();
				if(check())
				{
					System.out.println(name+" Wins!!!!!!");
					System.exit(0);
				}
				else if(player==9)
				{
					System.out.println("Its is drawn!!!!");
					System.exit(0);
				}
				return name+" inserted.....\n";
			}
			else
			{
				return "already exist\n";
			}
			
		}
		return "please enter the correct input\n";
	}
	
	
	
	public static boolean check() {
		String line="";
		for(int i=1;i<=8;i++)
		{
			switch(i) {
			case 1:
			{
				line=board[0]+board[1]+board[2];
				break;
			}
			case 2:
			{
				line=board[3]+board[4]+board[5];
				break;
			}
			case 3:
			{
				line=board[6]+board[7]+board[8];
				break;
			}
			case 4:
			{
				line=board[0]+board[3]+board[6];
				break;
			}
			case 5:
			{
				line=board[1]+board[4]+board[7];
				break;
			}
			case 6:
			{
				line=board[2]+board[5]+board[8];
				break;
			}
			case 7:
			{
				line=board[0]+board[4]+board[8];
				break;
			}
			case 8:
			{
				line=board[2]+board[4]+board[6];
				break;
			}
			}
			if(line.equals("XXX"))
			{
				return true;
			}
			else if(line.equals("OOO"))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		print();
		while(flag)
		{
			getMsg();
		}
	}
}

