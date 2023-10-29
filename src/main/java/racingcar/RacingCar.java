package racingcar;

public class RacingCar {
    private String carName;
    private int currentPosition = 0;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public RacingCar createNewCar(String carName) {
        return new RacingCar(carName);
    }

    public void move() {
        currentPosition++;
    }

    public String getCarName() {
        return carName;
    }

    public void printCurrentPositionWithName() {
        System.out.print(this.carName + " : ");
        printPositionAsDashes();
        System.out.println();
    }

    private void printPositionAsDashes() {
        for (int i = 0; i < this.currentPosition; i++) {
            System.out.print("-");
        }
    }
}
