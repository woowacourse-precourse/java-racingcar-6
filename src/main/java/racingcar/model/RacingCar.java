package racingcar.model;

public class RacingCar {
    private final String name;
    private int position;

    private RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public static RacingCar createRacingCar(final String name) {
        return new RacingCar(name);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getResult() {
        return this.name + " : " + "-".repeat(this.position);
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
