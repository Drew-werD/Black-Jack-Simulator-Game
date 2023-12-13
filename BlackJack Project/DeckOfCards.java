import java.util.ArrayList;

/** The DeckOfCards class represents the deck of cards both the dealer and user
 *    will use to play the game.
 *    @author Andrew White and Rohan Malhotra
 */
public class DeckOfCards
{

   /** DeckOfCards - A constructor that declares and initializes the size of "theDeck"
    *    arrayList.
    */
   public DeckOfCards()
   {
      theDeck = new ArrayList<>(Suits.values().length * Ranks.values().length);
   }


   /** CreateDeck - A function that clears the "theDeck" variable and resets the "maxNum"
    *    variable. After that, the deck is then created by a nested for-loop that goes
    *    through the Rank and Suits enumerations and populates "theDeck" variable with
    *    a Rank and Suit pair.
    */
   public void createDeck()
   {
      theDeck.clear();
      resetMaxNumber();

      for (Suits suit: Suits.values())
      {
         for (Ranks rank: Ranks.values())
         {
            Cards c = new Cards(suit, rank);
            theDeck.add(c);
         }
      }
   }

   /** ResetMaxNumber - Resets the "maxNum" variable to 52.
    *
    */
   public void resetMaxNumber()
   {
      this.maxNum = 52;
   }


   /** DisplayCard - Displays the information of the drawn card to the User.
    * @param card A Card object used to hold the card that is drawn from the deck
    */
   public void displayCard(Cards card)
   {
      System.out.println("You've drawn the " + card.getTheRank() + " of " + card.getTheSuit());
   } // end displayCard() method

   /** GenerateRandomNumber - Generates a random number between the minNum and maxNum
    *    variables.
    * @return Random number between the min/max numbers.
    */
   public int generateRandomNumber()
   {
      return (int)(Math.random() * (maxNum - minNum) + minNum);
   }

   /** DrawCard - Creates an instance of the Card object, generates random number, saves
    *    the random card inside the Card object previously created, removes the card from
    *    deck and reduces the "maxNum" variable by one.
    * @return The Card object
    */
   public Cards drawCard()
   {
      Cards theCard;
      int randomNum = generateRandomNumber();
      theCard = theDeck.get(randomNum);
      theDeck.remove(theCard);
      maxNum--;
      return theCard;
   } // end drawCard()


   /** PointSystem - Method distributes points based on drawn card's rank and
    *    current player's points, making sure that if the player's current points equal
    *    eleven or more, then the "ACE" would add one point to the player's score, else, it
    *    will add eleven to the player's score.
    *
    * @param rank The Rank of the drawn Card object
    * @param player The current player
    * @return points based on the ranking of the card and player's current score
    */
   public int pointSystem(Ranks rank, Player player)
   {
      int point = 0;
      switch (rank)
      {
         case TWO:
            point = 2;
            break;

         case THREE:
            point = 3;
            break;

         case FOUR:
            point = 4;
            break;

         case FIVE:
            point = 5;
            break;

         case SIX:
            point = 6;
            break;

         case SEVEN:
            point = 7;
            break;

         case EIGHT:
            point = 8;
            break;

         case NINE:
            point = 9;
            break;

         case TEN, JACK, QUEEN, KING:
            point = 10;
            break;

         case ACE:
            if (player.getPoints() >= 11)
            {
               point = 1;
            }
            else
            {
               point = 11;
            }
            break;
      }
      return point;
   } // end of pointSystem()

   /** Array of Enumerations called "Suits"
    */
   protected enum Suits
   {
      SPADES,
      HEARTS,
      DIAMONDS,
      CLUBS
   } // end Suits enum array

   /**  Array of Enumerations called "Ranks"
    */
   protected enum Ranks
   {
      TWO,
      THREE,
      FOUR,
      FIVE,
      SIX,
      SEVEN,
      EIGHT,
      NINE,
      TEN,
      JACK,
      QUEEN,
      KING,
      ACE
   } // end Ranks enum array

   // Declare Variables
   private ArrayList<Cards> theDeck;
   private int minNum = 0;
   private int maxNum = 52;
} // end of DeckOfCards class
