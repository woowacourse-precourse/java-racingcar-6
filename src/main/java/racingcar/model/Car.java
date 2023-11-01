package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car implements Comparable<Car> {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVE_THRESHOLD = 4;
    private static final String MOVE_MARK = "-";
    private static final String NAME_HYPHEN_SEPARATOR = " : ";

    private String name;
    private StringBuilder moveMarks;

    public Car(String name) {
        this.name = name;
        moveMarks = new StringBuilder();
    }

    public void attemptMove() {
        int randomNumber = pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (randomNumber >= MOVE_THRESHOLD) {
            move();
        }
    }

    private void move() {
        this.moveMarks.append(MOVE_MARK);
    }

    @Override
    public String toString() {
        return name + NAME_HYPHEN_SEPARATOR + moveMarks.toString();
    }


    @Override
    public int compareTo(Car comparedCar) {
        return comparedCar.getMoveCount() - this.getMoveCount();
    }

    public int getMoveCount() {
        return moveMarks.length();
    }

    public String getName() {
        return name;
    }
}
