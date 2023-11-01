package racingcar;

public class Car {
    private final Information information;
    Car (String name) {
        information = new Information(name);
    }

    void move(int speed) {
        if (moveSuccessfully(speed)) {
            information.update();
        }
    }

    private boolean moveSuccessfully(int speed) {
        return (speed >= 4);
    }

    void printInformation() {
        information.print();
    }

    String getName() {
        return (information.getName());
    }

    int getDestination() {
        return (information.getDestination());
    }
}
