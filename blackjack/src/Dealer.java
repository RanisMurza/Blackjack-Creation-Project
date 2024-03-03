//создаем Дилера
public class Dealer extends Person{
    public Dealer(){
        //дилеру очевидно присваиваем имя "Дилер"
        super.setName("Дилер");
    }
    public void printFirstHand(){
        System.out.println("Рука Дилера выглядит следующим образом:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("Вторая карта Дилера перевернута.");
    }
}
