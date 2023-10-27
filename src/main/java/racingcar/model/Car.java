package racingcar.model;

public class Car {
    private final String name;
    private Integer distance;

    public Car(String name) {
        this.name = validName(name);
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public void addDistance(int dice, int forward) {
        validDice(dice, forward);
        if (dice >= forward) {
            distance++;
        }
    }

    private void validDice(int dice, int forward) {
        if (dice < 0 || dice > 9 || forward < 0 || forward > 9) {
            throw new IllegalArgumentException();
        }
    }

    public String getDistanceLine() {
        StringBuilder stringBuilder = new StringBuilder();
        return String.valueOf(
                stringBuilder.append(getName()).append(" : ").append("-".repeat(Math.max(0, this.distance))));
    }

    public Integer getDistance() {
        return distance;
    }

    private String validName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        return name;
    }
}
