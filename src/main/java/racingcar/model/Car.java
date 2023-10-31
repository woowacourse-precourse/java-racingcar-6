package racingcar.model;

import racingcar.utils.Util;

public class Car {
  //  public static final String ROUND_RESULT_DELIMITER = " : ";
    public static final int GO_NUM = 4;
    private final String NAME;
    private int position = 0;

    public Car(String name) {
        this.NAME = name;
    }

    public void move() {
        if (Util.getRandomNum() >= GO_NUM) {
            position++;
        }
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
        return NAME + " : " + Util.repeatDash(position);
    }

}
