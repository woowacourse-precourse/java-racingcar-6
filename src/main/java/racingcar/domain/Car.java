package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    static private final String FORMAT = "%s : %s\n";
    static private final String INDICATOR = "-";
    static private final int NAME_LENGTH_MIN_LIMIT = 1;
    static private final int NAME_LENGTH_MAX_LIMIT = 5;
    static private final int MOVE_FORWARD_MIN_NUMBER = 4;
    private String name;
    private int moveCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
        moveCount = 0;
    }

    private void validateName(String name) {
        if (name.length() < NAME_LENGTH_MIN_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_MIN_LIMIT.toString());
        }
        if (name.length() > NAME_LENGTH_MAX_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_MAX_LIMIT.toString());
        }
    }

    protected void randomMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MOVE_FORWARD_MIN_NUMBER) {
            moveCount++;
        }
    }

    protected String getMoveResult() {
        String moveIndicator = INDICATOR.repeat(moveCount);
        String moveResult = String.format(FORMAT, name, moveIndicator);
        return moveResult;
    }

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(otherCar.moveCount, this.moveCount);
    }

    protected WinnerData createWinnerData() {
        return new WinnerData(moveCount);
    }

    protected boolean isWinner(WinnerData winnerData) {
        return (winnerData.compareMoveCount(moveCount) == 0);
    }

    protected void addWinner(WinnerData winnerData) {
        winnerData.addWinnerName(name);
    }
}
