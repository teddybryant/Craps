
/**
 * This method allows you to play the dice game Craps!
 *
 * @author Teddy Bryant
 * @version 2020-1-16
 */
import java.util.Scanner;
public class Craps
{
    public static void giveInstructions(Scanner in) // asks and gives instructions for Craps
    {
        System.out.println("Do you want instruction on how to play Craps (Y/n)?");
        String instruct = in.nextLine();
        if (instruct.equals("") || instruct.substring(0,1).equalsIgnoreCase("y"))
        {
            System.out.println("First you roll two die and if those die add up to 7 or 11 you win!");
            System.out.println("With that first roll, if the sum is 2, 3 or 12 you lose :(");
            System.out.println("If you get some other number for your sum that becomes the point value");
            System.out.println("Keep rolling until you get either that point value or 7");
            System.out.println("If you get your point value you win and if you get 7 you lose");
        }
    }
    public static void main(String[] args)
    {
       Scanner in = new Scanner(System.in);
       System.out.println("Lets play some Craps!");
       giveInstructions(in);
       String playStatus = "y";
       while (playStatus.equals("") || playStatus.substring(0,1).equalsIgnoreCase("y")) // play again mechanic
       {
           Die d = new Die(); // uses Die class to roll a die from 1-6
           System.out.println("Have fun!");
           System.out.println("Press <Enter> to roll");
           in.nextLine();
           int result1 = d.roll();
           int result2 =d.roll();
           int point = result1 + result2;
           System.out.println("You rolled a " + result1 + " and " + result2 + " so your sum is: " + point);
           if (point == 7 || point == 11)
           {
               System.out.println("You win!");
           }
           else if (point == 2 || point == 3 || point == 12)
           {
               System.out.println("You lose!");
           }
           else 
           {
               System.out.println("Now you are going to try to roll " + point + " again!");
               int total = 0;
               while (point != 7 || point != total) //loop until you lose or win
               {
                   System.out.println("Press <Enter> to roll");
                   in.nextLine();
                   result1 = d.roll();
                   result2 =d.roll();
                   total = result1 + result2;
                   System.out.println("You rolled a " + result1 + " and " + result2 + " so your sum is: " + total);
                   if (point == total)
                   {
                       System.out.println("You won!");
                       break;           // used to get out of the while loop that is having you roll
                   }
                   else if (total == 7)
                   {
                       System.out.println("You lose!");
                       break;           // used to get out of the while loop that is having you roll
                   }
               }
               
           }
           System.out.println("Do you want to play again? (Y/n)");
           playStatus = in.nextLine();
       }
       System.out.println("Ok goodbye :(");
    }
}
