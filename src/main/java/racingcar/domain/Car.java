package racingcar.domain;

import static racingcar.constant.NumberConstant.GAME_PROCEED_STANDARD;

import racingcar.constant.StringConstant;

public class Car implements Comparable<Car> {

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

        if (number >= GAME_PROCEED_STANDARD.getMessage()) {
            this.position++;
        }
    }

    public void printGameProceed() {
        System.out.print(this.name + " : ");
        for (int proceed = 0; proceed < this.position; proceed++) {
            System.out.print(StringConstant.GAME_PROCEED_CHAR.getMessage());
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
