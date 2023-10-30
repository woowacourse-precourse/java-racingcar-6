package game.car;

public class Car {
    CarName carName;
    int position;

    public Car(String inputSting) {
        this.carName = new CarName(inputSting);
        this.position = 0;
    }

    public void moveForward() {

    }
}
