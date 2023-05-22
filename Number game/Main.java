import java.util.Scanner;
import java.util.Random;

class NumGame
{
    int randnum;
    int userinput;
    int noofguesses;
	int choice;

	Scanner scan = new Scanner(System.in);

	void choose()
	{
		System.out.println("Enter your choice \n1.Start new game\n2.Exit");
		choice= scan.nextInt();
		if(choice==1)
		{
			noofguesses=0;
			startGame();
		}
		else{
			System.out.println("Thanks for Playing......");
			System.exit(0);
		}
	}

    void startGame()
    {
        int c=0;
		Random rand= new Random();
		randnum = rand.nextInt(100)+1;
		while(noofguesses<10)
		{
		    
		    System.out.println("Can you guess the number:");
		    userinput=scan.nextInt();
		    if(userinput>randnum)
		    {
		        if(userinput-randnum>25)
				  System.out.println("Very High");
				else if(userinput-randnum>15)
				   System.out.println("High");
				else 
				   System.out.println("Little High");
		    }
		    else if(userinput<randnum)
		    {
		        if(randnum-userinput>25)
				  System.out.println("Very Low");
				else if(randnum-userinput>15)
				   System.out.println("Low");
				else 
				   System.out.println("Little Low");
		    }
		    else 
		    {
		        System.out.println("Congratulations,  you guess the number "+randnum +" in " +noofguesses +" guesses");
		        System.out.println("Your score is:"+(100-10*noofguesses));
				choose();
		        c=1;
				break;
		    }
		    
		    
		    noofguesses++;
		    
		}
		if(c==0)
		{
		   System.out.println("Sorry,your chances are completed");
		   System.out.println("You lost");
		   choose();
		}
      
    }

}
class  Main 
{
	public static void main(String[] args) {
		NumGame obj = new NumGame();
		obj.startGame();
	}
}