package racingcar;

public class Car {
    final static int MOVING_FORWARD = 4;
    private String name;
    private int currentStep = 0;

    public Car(String name) {
        this.name = name;
    }

    public boolean isMovingForward(int randomNumber) {
        return randomNumber >= MOVING_FORWARD;
    }

    public void startGameTurn() {
        Number number = new Number();
        int randomNumber = number.generateRandomNumber();

        if (isMovingForward(randomNumber)) {
            increaseCurrentStep();
        }
    }

    public void increaseCurrentStep() {
        this.currentStep++;
    }

    public void showCurrentStep() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < currentStep; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public String getName() {
        return name;
    }
}