package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(Integer power){
        if (power >= 4) position++;
    }


}
