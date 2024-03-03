public class Main {
    public static void main(String[] args) throws Exception{
        //say hi to the user
        System.out.println("Welcome to Blackjack!");
        //create and start the Game
        Game blackjack = new Game();
        Deck deck = new Deck(true);
        deck.shuffle();
        Hand hand = new Hand();
        hand.takeCardFromDeck(deck);
        hand.takeCardFromDeck(deck);
        hand.takeCardFromDeck(deck);
        hand.takeCardFromDeck(deck);
        System.out.println(hand);
        System.out.println(hand.calculatorValue());
    }
}