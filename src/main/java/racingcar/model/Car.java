package racingcar.model;

public class Car {

    private String name;
    private int moveCount;

    public Car(String name){
        this.name=name;
        this.moveCount=0;
    }

    public void move(){
        moveCount+=1;
    }

    public int getMoveCount(){
        return moveCount;
    }

    public String getName(){
        return name;
    }

}
