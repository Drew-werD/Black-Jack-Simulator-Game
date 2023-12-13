/** This class represents the Dealer, which implements the Player interface
 *
 * @author Andrew White
 */
public class Dealer implements Player {


   /** Dealer - A constructor to declare that this object has zero points
    */
   Dealer()
   {
      this.points = 0;
   } // end Dealer() constructor

   /** CalculatePoints - adds the points from the last card to your total points
    *
    * @param points Points generated from the card that was drawn
    */
   @Override
   public void calculatePoints(int points) {
      this.points += points;
   } // end calculatePoints() method


   /** ResetPoints - Reset's dealer points to zero
    */
   @Override
   public void resetPoints()
   {
      this.points = 0;
   } // end resetPoints() method


   /** TheirTurn - Entails the sequence of steps the dealer takes when it's their turn
    *    from drawing the card, determining the points generated from the card and then
    *    adding those points to the dealer's overall points.
    *
    * @param drawnCard A Card object used to hold the card that is drawn from the deck
    * @param deck A DeckOfCard object used to generate random card from deck
    */
   @Override
   public void theirTurn(Cards drawnCard, DeckOfCards deck)
   {
      int pointsFromDrawnCard;
      drawnCard = deck.drawCard();
      pointsFromDrawnCard = deck.pointSystem(drawnCard.getTheRank(), this);
      this.calculatePoints(pointsFromDrawnCard);
   } // end theirTurn() method

   @Override
   public int getPoints() {
      return this.points;
   } // end getPoints() method

   /** HitOrStay - Determines whether the dealer pulls another card or no based on
    *    the dealer's current points
    *
    * @return True if points are below 17. If points are 17, or above, the dealer will
    *    randomly decide whether to hit (return true) or stay (return false)
    */
   @Override
   public boolean hitOrStay()
   {
      if (this.points < 17)
      {
         System.out.println("Dealer hits...");
         return true;
      }
      else
      {
         if (Math.random() < 0.50)
         {
            System.out.println("Dealer hits...");
            return true;
         }
         else
         {
            System.out.println("Dealer stays...");
            return false;
         }
      }
   } // end hitOrStay() method

   /** DrawingInitialCards - Dealer deals two cards to itself and adds
    *    calculated points to dealers overall points
    * @param deck A DeckOfCard object used to generate random card from deck
    * @param card A Card object used to hold the card that is drawn from the deck
    */
   @Override
   public void drawingInitialCards(DeckOfCards deck, Cards card)
   {
      System.out.println("Dealing cards to dealer...");
      for(int i = 0; i < 2; i++)
      {
         card = deck.drawCard();
         int points = deck.pointSystem(card.getTheRank(), this);
         this.calculatePoints(points);
      }
   } // end drawingInitialCards() method

   /** Won - Prints out victory statement
    */
   public void won()
   {
      System.out.println("The Dealer won!");
   } // end won() method

   /** Lost - Prints out defeated statement
    */
   public void lost()
   {
      System.out.println("The Dealer lost!");
   } // end lost() method

   // Declaring points variable
   private int points;
} // end Dealer Class
