package racingcar;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    public Car(String name, int position) {
        name = name.trim();
        validateName(name);
        this.name = name;
        this.position = position;
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

    public boolean isSamePosition(Car car) {
        return car.position == this.position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return o.position - this.position;
    }

    private void validateName(String name) {
        if (name.length() > GameConfig.MAX_CAR_NAME.getValue() || name.length() < GameConfig.MIN_CAR_NAME.getValue()) {
            throw new IllegalArgumentException("잘못된 이름입니다.");
        }
    }
}
