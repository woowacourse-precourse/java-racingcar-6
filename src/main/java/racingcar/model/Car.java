package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.message.ErrorMessage;

public class Car implements Comparable<Car> {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String POSITION_BAR = "-";

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int rand = Randoms.pickNumberInRange(0, 9);

        if (rand >= 4) {
            this.position++;
        } else {

        }
        System.out.println(name + " : " + POSITION_BAR.repeat(position));
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
        }
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.getPosition(), this.position);
    }
}
