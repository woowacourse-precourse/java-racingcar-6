package racingcar;

public class RacingCar {

    private String carName;
    private int distance;

    public RacingCar(final String carName){
        this.carName = carName;
        this.distance = 0;
    }

    public void plusDistance(){
        this.distance += 1;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
