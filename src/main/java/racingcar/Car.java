package racingcar;

public class Car {
    String name;
    int advancedDistance;

    public Car(String name){
        this.name = name;
        this.advancedDistance = 0;
    }

    public void tryForwardChance(){
        int randomNumber = NumberGenerator.createRandomNumber();
        if(randomNumber >= 4){
            this.forward();
        }
    }

    private void forward(){
        this.advancedDistance++;
    }

    public void printForawrdSituation(){
        System.out.print(name + " : ");
        for(int i=0; i<advancedDistance; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
