public enum Rank {
    TWO("Два", 2),
    THREE("Три", 3),
    FOUR("Четыре",4),
    FIVE("Пять",5),
    SIX("Шесть",6),
    SEVEN("Семь",7),
    EIGHT("Восемь",8),
    NINE("Девять",9),
    TEN("Десять",10),
    JACK("Валет",10),
    QUEEN("Дама",10),
    KING("Король",10),
    ACE("Туз", 11);

    private String rankName;
    private int rankValue;
    Rank(String rankName, int rankValue){
        this.rankName = rankName;
        this.rankValue = rankValue;
    }
    public String toString(){
        return rankName;
    }
    public int getRankValue(){
        return rankValue;
    }
}
