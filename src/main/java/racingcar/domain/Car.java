package racingcar.domain;

public class Car {
    private String name;
    private int moveState;

    public Car(String name) {
        this.name = name;
        this.moveState = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveState() {
        return moveState;
    }

    public void printCar() {
        System.out.print(this.name + " : ");
        System.out.println(makeCarMovementGUI(this.moveState));
    }

    private String makeCarMovementGUI(int moveState) {
        StringBuilder carGUI = new StringBuilder();
        for (int i = 0; i < moveState; i++) {
            carGUI.append("-");
        }
        return carGUI.toString();
    }
}
