import java.util.Random;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Random rnd=new Random();
        Scanner in=new Scanner(System.in);


        int NewWin=1;
        boolean plays=true;
        boolean secondRoll=false;
        String play="Y";

        do
        {
            int die1=rnd.nextInt(6) + 1;
            int die2=rnd.nextInt(6) + 1;
            int crapsRoll=die1 + die2; // Gaussian range from 2 to 12 as in rolling two dice

            if (crapsRoll==2 || crapsRoll==3 || crapsRoll==12)
            {
                System.out.println(crapsRoll + ": Craps! you loose");
                plays = false;
            }

            else if (crapsRoll==7 || crapsRoll==11)
            {
                System.out.println(crapsRoll + ": You're a natural! you win!");
                plays = false;
            }

            else
            {
                NewWin = crapsRoll;
                secondRoll = true;
                System.out.println(NewWin + " is your new target roll");
                do
                {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    crapsRoll = die1 + die2;

                    if (crapsRoll == NewWin)
                    {
                        System.out.println(crapsRoll + " You win!");
                        secondRoll = false;
                        plays = false;
                    }
                    else if (crapsRoll == 7)
                    {
                        System.out.println(crapsRoll + " You loose");
                        secondRoll = false;
                        plays = false;
                    }
                    else
                    {
                        System.out.println(crapsRoll + " You can roll again");
                        secondRoll = true;
                    }

                } while (secondRoll == true);
            }

       System.out.print("Would you like to play again? [Y/N] ");
        play = in.nextLine();
        if (play.equalsIgnoreCase("Y"))
        {
            //System.out.println("play again");
            plays = true;

        }
        else if (play.equalsIgnoreCase("N"))
        {
            System.out.println("Thanks for playing");
            plays = false;
            System.exit(0);
        }
        else
        {
            System.out.println(play + " is not a valid answer");
        }


        } while (plays == true);

    }
}