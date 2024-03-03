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
        if(wins>0 || losses>0 || pushes > 0){
            System.out.println();
            System.out.println("Начинаем следующий раунд... Победы: " + wins + " Поражений: "+ losses+ " Ничьих: "+pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        //Проверяем, осталось ли в колоде по крайней мере 4 карты
        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscard(discarded);
        }
        //Берем две карты для Дилера
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);
        //Берем две карты для Игрока
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);
        //выводим на экран руки Дилера и Игрока
        dealer.printFirstHand();
        player.printHand();
        //проверяем, есть ли у Дилера или у Игрока Блэкджек после раздачи карт
        if(dealer.hasBlackjack()){
            //Показываем, что у Дилера действительно Блэкджек
            dealer.printHand();
            //Проверяем, а вдруг у Игрока тоже Блэкджек
            if(player.hasBlackjack()){
                //Ничья
                System.out.println("У Вас и у Дилера по 21 очку. Ничья!");
                pushes++;
                startRound();
            }
            //если у Игрока нет Блэкджека
            else{
                System.out.println("У Дилера Блэкджек. Вы проиграли!");
                dealer.printHand();
                losses++;
                startRound();
            }
        }

        //Проверяем, имеет ли Игрок Блэкджек в начале
        //Если мы дошли до этого момента, то уже знаем, что у дилера не было Блэкджека
        if(player.hasBlackjack()){
            System.out.println("У тебя Блэкджек! Ты выиграл!");
            wins++;
            startRound();
        }
        //если ничего не вывелось, то мы понимаем, что ни у кого из Игроков нет Блэкджека
        //тогда мы даем взять карты Игроку
        player.makeDecision(deck,discarded);
        //Проверка того, не стало ли у Игрока больше 21 очков после взятия карт
        if(player.getHand().calculatorValue() > 21){
            System.out.println("У тебя больше 21 очков.Ты проиграл!");
            losses ++;
            //начинаем следующий раунд
            startRound();
        }
        //Если мы прошли этот пункт, то наступает время Дилера - он берет карты, пока его очки не станут >=17
        dealer.printHand();
        while(dealer.getHand().calculatorValue()<17){
            dealer.hit(deck, discarded);
        }
        if(dealer.getHand().calculatorValue()>21){
            System.out.println("У Дилере перебор. Вы выиграли!");
            wins++;
        }
        else if(dealer.getHand().calculatorValue() > player.getHand().calculatorValue()){
            System.out.println("У Дилера больше очков. Вы проиграли!");
            losses++;
        }
        else if(player.getHand().calculatorValue() > dealer.getHand().calculatorValue()){
            System.out.println("У Вас больше очков. Вы выиграли!");
            wins++;
        }
        else{
            System.out.println("У Вас и Дилера одинаковое количество очков. Ничья!");
            pushes++;
        }
        //старт нового раунда
        startRound();
    }
}
