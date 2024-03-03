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
    //проверка того, есть ли в колоде карты
    public boolean hasCards(){
        if (deck.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }
    //очистка колоды
    public void emptyDeck(){
        deck.clear();
    }
    //добавление нескольких карт в колоду
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }
    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getDeck());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Закончились карты, создаем новую колоду из стопки сброса и перетасовываем колоду.");
    }
    public int cardsLeft(){
        return deck.size();
    }
    public ArrayList<Card> getDeck(){
        return deck;
    }
}
