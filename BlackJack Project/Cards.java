/** The Cards class represents a single Card object
 *    and extends the "DeckOfCards" class.
 *    @author Andrew White
 */
public class Cards extends DeckOfCards{

   /** Cards - A constructor that creates a card object given a rank and suit.
    *
    * @param theSuit A variable from the "Suits" enum array
    * @param theRank A variable from the "Ranks" enum array
    */
   public Cards(Suits theSuit, Ranks theRank)
   {
      this.theSuit = theSuit;
      this.theRank = theRank;
   }

   public Suits getTheSuit()
   {
      return theSuit;
   } // end getTheSuit() method

   public Ranks getTheRank()
   {
      return theRank;
   } // end getTheRank() method


   /** toString - Prints the Card object in the form of a string.
    *
    * @return A string that represents the Card object
    */
   public String toString()
   {
      return "Card [Suit=" + getTheSuit() + ", Rank=" + getTheRank() + "]";
   } // end toString() method

   // Declare Variables
   private Suits theSuit;
   private Ranks theRank;
}
