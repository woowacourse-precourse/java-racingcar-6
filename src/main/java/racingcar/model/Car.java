package racingcar.model;

public class Car {
    private String name;
    private Integer position;
    private static final Integer INITIAL_STATUS = 0;

    private Car(String name, int status) {
        this.name = name;
        this.position = position;
    }

    public static Car makeCar(String name) {
        return new Car(name, INITIAL_STATUS);
    }

    public void move() {
        position++;
    }

    public String getStatusString() {
        String postionString = "";
        for (int i = 0; i < position; i++) {
            postionString += "-";
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(name).append(" : ").append(postionString).toString();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}