package racingcar.domain;

import static racingcar.utils.Console.println;

import racingcar.enums.GameCondition;
import racingcar.enums.Symbols;

public class Car {
    private final String name;
    private int position = GameCondition.START_POSITION.getValue();
    private static final String RESULT_FORMAT = "%s : %s";

    public Car(final String name) {
        this.name = name;
    }

    public void moveForward() {
        position += GameCondition.CAR_SPEED.getValue();
    }

    public boolean isMaxPosition(final int maxPosition) {
        return position == maxPosition;
    }

    public void printCarResult() {
        String positionStr = new String(new char[position]).replace("\0", Symbols.GAME_SCORE.getSymbol());
        println(String.format(RESULT_FORMAT, name, positionStr));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
