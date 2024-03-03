public class Game {
    //количество побед, поражений и игр
    private int wins, losses, pushes;
    //в игре должны присутствовать Дилер и Игрок
    private Dealer dealer;
    private Player player;
    //а также сама колоды(основная и отбрасываемая)
    private Deck deck, discarded;
    public Game() throws Exception {
        //в начале игры все счетчики равны нулю
        wins = 0;
        losses = 0;
        pushes = 0;
        //создаем основную колоду
        deck = new Deck(true);
        //создаем пустую колоду
        discarded = new Deck();
        //создаем Дилера и Игрока
        dealer = new Dealer();
        player = new Player();
        //Перемешиваем колоду и начинаем раунд
        deck.shuffle();
        startRound();
    }
    private void startRound() throws Exception {
        //Берем две карты для Дилера
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);
        //Берем две карты для Игрока
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

    }
}
