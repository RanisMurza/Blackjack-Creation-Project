//класс мастей
public enum Suit {
    CLUB("Clubs"), //трефы
    DIAMOND("Diamonds"), //бубны
    HEART("Hearts"), //Черви
    SPADE("Spades"); //Пики
    private String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }
    public String toString(){
        return suitName;
    }
    public String getSuitName(){
        return suitName;
    }
}
