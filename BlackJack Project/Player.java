/** The Player interface is used to define common features between
 *  the Dealer and User classes would have when playing BlackJack.
 *  @author Andrew White
 */
interface Player{

   /** CalculatePoints - Adds the points from the last card the user/dealer received to
    *    their overall points.
    * @param points Points generated from the card tha was drawn.
    */
   public void calculatePoints(int points);

   /** ResetPoints - Reset's dealer points to zero
    */
   public void resetPoints();

   /** TheirTurn - Entails the sequence of steps the dealer/user takes when it's their turn
    *    and then adding the points gained from drawn card to the current players
    *    overall points.
    *
    * @param drawnCard A Card object used to hold the card that is drawn from the deck
    * @param deck A DeckOfCard object used to generate random card from deck
    */
   public void theirTurn(Cards drawnCard, DeckOfCards deck);

   public int getPoints();


   /** HitOrStay - Used to determine whether to hit or stay, depending on the current player
    *
    * @return True for "hit", or False for "stay"
    */
   public boolean hitOrStay();

   /** DrawingInitialCards - Current player receives two cards and adds the point from both
    *    cards to the current players overall points.
    * @param deck A DeckOfCard object used to generate random card from deck
    * @param card A Card object used to hold the card that is drawn from the deck
    */
   public void drawingInitialCards(DeckOfCards deck, Cards card);
}// end Player Class
