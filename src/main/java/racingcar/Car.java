package racingcar;

public class Car {
    String name;
    int position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public String getName(){
        return name;
    }
    public int getPosition() {
        return position;
    }

    public void tryForwardChance(){
        int randomNumber = NumberGenerator.createRandomNumber();
        if(randomNumber >= 4){
            this.forward();
        }
    }

    private void forward(){
        this.position++;
    }

    public void printForawrdSituation(){
        System.out.print(name + " : ");
        for(int i = 0; i< position; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
