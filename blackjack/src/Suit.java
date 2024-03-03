//класс мастей
public enum Suit {
    CLUB("Треф"), //трефы
    DIAMOND("Бубен"), //бубны
    HEART("Черви"), //Черви
    SPADE("Пики"); //Пики
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
