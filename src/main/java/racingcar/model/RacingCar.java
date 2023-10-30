package racingcar.model;

public class RacingCar {
    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    private void move() {
        this.position++;
    }

    public void tryMove() {
        RandomNumber randomNumber = RandomNumber.createNumber();

        if (randomNumber.getNumber() >= 4) {
            move();
        }
    }
}
