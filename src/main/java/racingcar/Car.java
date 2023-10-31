package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= GameConfig.MIN_MOVE_VALUE.getValue()) {
            position++;
        }
    }

    public String getExecuteResult() {
        StringBuilder executeResult = new StringBuilder(name);
        executeResult.append(GameMessage.COLON.getMessage());
        for (int i = 0; i < position; i++) {
            executeResult.append(GameMessage.EXECUTE_RESULT_SIGN.getMessage());
        }

        return executeResult.toString();
    }
}
