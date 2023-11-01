package racingcar;

public class Car {
    private String carName;
    private String state;

    public Car(String carName, String state) {
        this.carName = carName;
        this.state = state;
    }

    public String getCarName() {
        return carName;
    }
    public String getState() {
        return state;
    }

    public void progress(){
        state = state.concat("-");
    }
}
