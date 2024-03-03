import java.util.ArrayList;

//колода
public class Deck {
    //колода будет состоять из списка карт
    private ArrayList<Card> deck;
    //создание пустой колоды
    public Deck(){
        deck = new ArrayList<>();
    }
    //создание колоды карт
    public Deck(boolean makeDeck){
        deck = new ArrayList<>();
        if(makeDeck){
            for(Suit suit : Suit.values()){
                for (Rank rank : Rank.values()){
                    deck.add(new Card(suit,rank));
                }
            }
        }
    }
    //метод для добавления карты в список
    public void addCard(Card card){
        deck.add(card);
    }
    //метод для перетасовки карт
    public void shuffle(){
        //перемешанная колода
        ArrayList<Card> shuffled = new ArrayList<Card>();
        while(deck.size()>0){
            int cardToPull = (int)(Math.random()*(deck.size()-1));
            shuffled.add(deck.get(cardToPull));
            deck.remove(cardToPull);
        }
        deck = shuffled;
    }
    //извлечение карты из колоды
    public Card takeCard() throws Exception{
        if(deck.size() > 0){
            Card cardToTake = new Card(deck.get(0));
            deck.remove(0);
            return cardToTake;
        }else{
            throw new Exception("The deck is empty.");
        }

    }
    public String toString(){
        String output = "";

        for(Card card: deck){
            output += card;
            output += "\n";
        }
        return output;
    }
    public ArrayList<Card> getDeck(){
        return deck;
    }
}
