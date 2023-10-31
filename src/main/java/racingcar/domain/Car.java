package racingcar.domain;

public class Car implements Comparable<Car> {

    private static final int GAME_PROCEED_STANDARD = 4;
    private static final String GAME_PROCEED_CHAR = "-";

    private final String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(name, 0);
    }

    public String getName() {
        return this.name;
    }

    public void movePosition(int randomNumber) {
        int number = randomNumber;

        if (number >= GAME_PROCEED_STANDARD) {
            this.position++;
        }
    }

    public void printGameProceed() {
        System.out.print(this.name + " : ");
        for (int proceed = 0; proceed < this.position; proceed++) {
            System.out.print(GAME_PROCEED_CHAR);
        }
        System.out.println();
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position - otherCar.position;
    }

    public boolean isSamePosition(Car otherCar) {
        return this.position == otherCar.position;
    }
}
