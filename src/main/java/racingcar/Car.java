package racingcar;

public class Car {
    public String name;
    public int move;
    public Car(String name){
        this.name = name;
        this.move = 0;
    }

    public String getName(){
        return this.name;
    }
    public int getMove(){
        return this.move;
    }
}
