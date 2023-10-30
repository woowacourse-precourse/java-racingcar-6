package racingcar;

public class Car {
    private String name;
    private int move;

    public Car(String name){
        this.name = name;
        this.move = 0;
    }

    public String getName(){
        return this.name;
    }
}
