package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public String getCarName(){
        return name;
    }

    public int getCarPosition(){
        return position;
    }

    public void move(){
        ++this.position;
    }
}
