package racingcar.domain;

public class CarController {
    private Cars cars;

    private int moveChance;

    public void setStatus(Cars cars, int moveChance) {
        this.cars = cars;
        this.moveChance = moveChance;
    }

    public void moveCars() {
        cars.move();
        moveChance--;
    }

    public boolean checkMoveChance() {
        return moveChance != 0;
    }

    public String findWinner() {
        return cars.findWinner();
    }
}
