package racingcar;

public class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름을 5글자 이내로 작성해 주세요.");
        }
        this.name = name;
    }

    public void move(int number) {
        if (number >= 4) {
            distance++;
        }
    }
    public String getName() {
        return name;
    }
    public String displayDistance() {
        StringBuilder distanceRepresentation = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            distanceRepresentation.append("-");
        }
        return distanceRepresentation.toString();
    }
    public int getDistance() {
        return distance;
    }
}
