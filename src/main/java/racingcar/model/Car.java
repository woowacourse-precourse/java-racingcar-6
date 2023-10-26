package racingcar.model;

public class Car {
    private String name;
    private Integer distance;

    public Car(String name) {
        this.name = validName(name);
        this.distance = 0;
    }

    public String getName() {
        return this.name;
    }

    public void addDistance(int dice) {
        if (dice >= 4) {
            this.distance++;
        }
    }

    public void getDistanceLine() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append(getName()).append(" : ").append("-".repeat(Math.max(0, this.distance))));
    }

    private String validName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        return name;
    }
}
