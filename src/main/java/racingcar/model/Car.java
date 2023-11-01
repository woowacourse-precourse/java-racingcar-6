package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.IntStream;

public class Car {
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
    public static final String DASH = "-";
    public static final int GO_NUM = 4;
    private final String NAME;
    private int position = 0;

    public Car(String name) {
        this.NAME = name;
    }

    public void move() {
        if (getRandomNum() >= GO_NUM) {
            position++;
        }
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }

    public String getName() {
        return NAME;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int winDistance) {
        return position == winDistance;
    }

    public String getRoundResult() {
        return NAME + " : " + repeatDash(position);
    }

    private String repeatDash(int num) {
        StringBuilder dashes = new StringBuilder();
        IntStream.range(0, num).forEach(i -> dashes.append(DASH));
        return dashes.toString();
    }

}
