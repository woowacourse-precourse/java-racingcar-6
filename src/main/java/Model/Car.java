package Model;

public class Car {
    private CarName carName;
    private CarPosition carPosition;

    public Car(String name) {
        carName = new CarName(name);
        carPosition = new CarPosition(0);
    }

    public void moveForward() {
        carPosition.incrementPosition();
    }

    public boolean isNameValid() {
        if (carName.isCarNameEmpty()) {
            return false;
        }
        if (!carName.isNameUnder5Characters()) {
            return false;
        }
        return true;
    }

    public void printCarName() {
        System.out.print(carName.getCarName());
    }

    public void printCarPosition() {
        int position = carPosition.getCarPosition();
        for (int i = 1; i <= position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public CarPosition getPosition() {
        return carPosition;
    }
}
