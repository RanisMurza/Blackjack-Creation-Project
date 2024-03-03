import java.util.ArrayList;
//рука
public class Hand {
    private ArrayList<Card> hand;
    public Hand(){
        hand = new ArrayList<>();
    }
    public void takeCardFromDeck(Deck deck) throws Exception {
        hand.add(deck.takeCard());
    }
    public String toString(){
        String output = "";
        for(Card card: hand){
            output += card + " - ";
        }
        return output;
    }
    public int calculatorValue(){
        int value = 0;
        int aceCount = 0;

        for(Card card : hand){
            value += card.getValue();
            if(card.getValue() == 11){
                aceCount++;
            }
        }
        if(aceCount > 0 && value > 21){
            while(aceCount > 0 && value > 21){
                value -= 10;
                aceCount --;
            }
        }
        return value;
    }
}
