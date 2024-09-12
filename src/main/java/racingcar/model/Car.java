package racingcar.model;

public class Car {
    private long id;
    private String carName;
    private int carPosition;

    public Car(long id, String carName, int carPosition) {
        this.id = id;
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public long getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    //model에 이런 기능 매서드 넣어도 될까? -> 될것같다고 하심
    public void increaseCarPosition() {
        this.carPosition++;
    }
}