package racingcar.model;

public class Car {
    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void movePosition() {
        RandomNumber randomNumber = new RandomNumber();
        if (randomNumber.isMovable()) {
            position.move(randomNumber.getNumber());
        }
    }

    public String getStatusString() {
        String postionString = "";
        for (int i = 0; i < position.getPosition(); i++) {
            postionString += "-";
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(name).append(" : ").append(postionString).toString();
    }

    public boolean isWinnerCondition(int maxScore) {
        return position.getPosition() == maxScore && position.getPosition() > 0;
    }

    public int getCarPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.toString();
    }
}