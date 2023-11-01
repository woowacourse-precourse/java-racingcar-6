package racingcar.main;

public class Car {
    private String carName;
    private int position = 0;

    public Car(String carName){
        this.carName = carName;
    }

    public void movingForward(int distance){
        position += distance;
    }

    public String getName() {
        return carName;
    }
    public int getPosition() {
        return position;
    }

}
