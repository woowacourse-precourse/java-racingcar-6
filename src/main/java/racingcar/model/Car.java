package racingcar.model;

public class Car {
    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void movePosition() {
        RandomNumber randomNumber = new RandomNumber();
        if (randomNumber.isMovable()) {
            position.move();
        }
    }

    public boolean isWinnerCondition(int maxScore) {
        return position.makeInt() == maxScore && position.makeInt() > 0;
    }

    public int getPosition() {
        return position.makeInt();
    }

    public String getName() {
        return name.toString();
    }

    public String getPositionString() {
        String positionString = makePositionString("");
        StringBuilder sb = new StringBuilder();
        return sb.append(name).append(" : ").append(positionString).toString();
    }

    private String makePositionString(String string) {
        for (int i = 0; i < position.makeInt(); i++) {
            string += "-";
        }
        return string;
    }
}