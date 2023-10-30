package racingcar;

public class Car {
    private String name;
    private int position = 0;
    public Car(String name){
        this.name = name;
    }
    public void moveForward(){
        position++;
    }
    public int getForward(){
        return position;
    }
    public String getName(){
        return name;
    }
}
