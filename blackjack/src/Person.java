//так как Player и Dealer являются людьми, то создадим для них абстрактный класс
public abstract class Person {
    private Hand hand;
    private String name;

    public Person(){
        this.hand = new Hand();
        this.name = "";
    }
    //проверка того, выбил ли Игрок blackjack
    public boolean hasBlackjack(){
        if(this.getHand().calculatorValue() == 21){
            return true;
        }
        else{
            return false;
        }
    }
    public Hand getHand(){
        return hand;
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void printHand(){
        System.out.println("Рука " + this.name + "а выглядит следующим образом: ");
        System.out.println(this.hand + " Количество очков: " + this.hand.calculatorValue());
    }
    //методы взятия карты
    public void hit(Deck deck, Deck discard) throws Exception {

        //If there's no cards left in the deck
        if (!deck.hasCards()) {
            deck.reloadDeckFromDiscard(discard);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " взял карту");
        this.printHand();
    }
}
