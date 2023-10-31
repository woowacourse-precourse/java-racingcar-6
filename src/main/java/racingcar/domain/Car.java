package racingcar.domain;

import racingcar.util.NumberGenerator;

public class Car implements Comparable<Car> {

    private final NumberGenerator numberGenerator;

    private static final int GAME_PROCEED_STANDARD = 4;
    private static final String GAME_PROCEED_CHAR = "-";
    private final String name;
    private int position;

    private Car(String name, int position, NumberGenerator numberGenerator) {
        this.name = name;
        this.position = position;
        this.numberGenerator = numberGenerator;
    }

    public static Car from(String name) {
        return new Car(name, 0, new NumberGenerator());
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void play() {
        if (checkProceed()) {
            this.position++;
        }
    }

    private boolean checkProceed() {
        return numberGenerator.generateRandomNumber() >= GAME_PROCEED_STANDARD;
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
