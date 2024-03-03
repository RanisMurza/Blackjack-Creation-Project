//создаем Игрока
import java.util.Scanner;
public class Player extends Person{

    Scanner input = new Scanner(System.in);

    public Player(){
        super.setName("Игрок");
    }
    public void makeDecision(Deck deck, Deck discard) throws Exception {
        //решение Игрока
        int  decision = 0;
        boolean getNum = true;

        //пока Игрок не наберет цифру 1 или 2
        while(getNum){

            try{
                System.out.println("Чтобы бы вы хотели: 1) Взять карту 2) Воздержаться");
                decision = input.nextInt();
                getNum = false;

            }
            catch(Exception e){
                System.out.println("Invalid");
                input.next();
            }
        }

        //показываем Игроку, что он выбрал
        
        System.out.println("Вы выбрали: " + decision);
        if (decision == 1) {
            //hit the deck using the deck and discard deck
            this.hit(deck, discard);
            //return (exit the method) if they have blackjack or busted
            if(this.getHand().calculatorValue()>20){
                return;
            }
            //if they didnt bust or get 21, allow them to decide to hit or stand again by going back to this same method
            else{
                this.makeDecision(deck, discard);
            }

            //if they type any number other than 1, we'll assume they're standing
        } else {
            System.out.println("You stand.");
        }
    }
}
