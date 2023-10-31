package racingcar.domain.car;

public class Car {
    private Name carName;
    private Distance carDistance;

    public Car(String carName) {
        this.carName = new Name(carName);
        this.carDistance = new Distance();
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getCarDistance(){
        return carDistance.getDistance();
    }

    public void forward(){
        carDistance.increaseDistance();
    }
}
