import java.util.Scanner;

/** BlackJackGameSimulator class is the main class that will incorporate the User,
 *    Cards, DeckOfCards and Dealer class. Along with the Player interface.
 *
 *    This program simulates a real-life Black Jack game between the User and
 *    Dealer. The player closest to having 21 points win, and if either player
 *    gets over 21 points, they immediately lose.
 *
 *    @author Andrew White
 *
 */
public class BlackjackGameSimulator {

   /** Main - Used to run the simulated game.
    * @param args N/A.
    */
   public static void main(String[] args)
   {
      // Instantiate Variables
      boolean doYouContinue = true;
      boolean wentOver21Points = false;
      boolean wantToHit = true;
      Cards drawnCard = null;
      Scanner input = new Scanner(System.in);

      // Create dealer and user, along with user's stats
      Dealer dealer = new Dealer();

      System.out.println("Hello challenger, what is your name? ");
      String userName = input.nextLine();
      User playerOne = new User(userName);

      System.out.println("Welcome, " + playerOne.getName() +
              ", to BlackJack!");
      System.out.println("Let the games begin!!!");
      System.out.println();
      System.out.println(playerOne);

      // Main loop that starts the game, creates the deck for both players
      // and deal user two cards
      while (doYouContinue == true && playerOne.getCurrency() > 0.0)
      {
         // Reset variables
         wentOver21Points = false;
         wantToHit = true;
         playerOne.resetPoints();
         dealer.resetPoints();

         // Ask user for the amount they'd like to gamble for this game.
         playerOne.promptUserForAmountGambled(input);

         // Create deck and draw initial two cards for the user
         DeckOfCards deck = new DeckOfCards();
         deck.createDeck();
         playerOne.drawingInitialCards(deck, drawnCard);
         System.out.println(playerOne);

         // Checks to see if user has 21 points immediately
         if (playerOne.getPoints() == 21)
         {
            System.out.println("Dealer: " + dealer.getPoints() + "\t" +
                    playerOne.getName() + ": " + playerOne.getPoints());
            dealer.lost();
            doYouContinue = playerOne.won();
            continue;
         }

         /* The second loop that asks user if they want to hit
            or stay. If they do, a function is called for their
            turn and checks to see if the user has over 21 points
         */
         while ((wentOver21Points == false) && (wantToHit == true))
         {
            wantToHit = playerOne.hitOrStay();
            if (wantToHit == true)
            {
               playerOne.theirTurn(drawnCard, deck);
            }
            if (playerOne.getPoints() > 21)
            {
               wentOver21Points = true;
            }
         } // end of second while loop

         // Checks to see if user went over 21 points
         if (wentOver21Points)
         {
            System.out.println("Dealer: " + dealer.getPoints() + "\t" +
                    playerOne.getName() + ": " + playerOne.getPoints());
            dealer.won();
            doYouContinue = playerOne.lost();
            continue;
         }

         // Reset the "wantToHit" variable from when the user played
         wantToHit = true;

         // End of user's turn, and beginning of dealers turn
         System.out.println(playerOne.getName() + "'s turn has ended."
                              + "It is now the dealer's turn.");

         // Dealer draws two cards
         dealer.drawingInitialCards(deck, drawnCard);

         // Checks to see if the dealer instantly won
         if (dealer.getPoints() == 21)
         {
            System.out.println("Dealer: " + dealer.getPoints() + "\t" +
                    playerOne.getName() + ": " + playerOne.getPoints());
            dealer.won();
            doYouContinue = playerOne.lost();
            continue;
         }


         /* The third while loop that lets' the dealer choose whether to hit or stay,
            and checks to see if the dealer's score is more than 21.
         * */
         while ((wentOver21Points == false) && (wantToHit == true))
         {
            wantToHit = dealer.hitOrStay();
            if (wantToHit == true)
            {
               dealer.theirTurn(drawnCard, deck);
            }
            if (dealer.getPoints() > 21)
            {
               wentOver21Points = true;
            }
         }

         // Checks to see if user went over 21 points
         if (wentOver21Points)
         {
            System.out.println("Dealer: " + dealer.getPoints() + "\t" +
                    playerOne.getName() + ": " + playerOne.getPoints());
            dealer.lost();
            doYouContinue = playerOne.won();
            continue;
         }

         if (playerOne.getPoints() > dealer.getPoints())
         {
            System.out.println("Dealer: " + dealer.getPoints() + "\t" +
                    playerOne.getName() + ": " + playerOne.getPoints());
            dealer.lost();
            doYouContinue = playerOne.won();
         }
         else if (dealer.getPoints() > playerOne.getPoints())
         {
            System.out.println("Dealer: " + dealer.getPoints() + "\t" +
                    playerOne.getName() + ": " + playerOne.getPoints());
            dealer.won();
            doYouContinue = playerOne.lost();
         }
         else
         {
            System.out.println("Dealer: " + dealer.getPoints() + "\t" +
                    playerOne.getName() + ": " + playerOne.getPoints());
            playerOne.draw();
         }
      }
      System.out.println("Thanks for playing, have a great day!");
   } // end of main()
} // end of BlackJack Class
