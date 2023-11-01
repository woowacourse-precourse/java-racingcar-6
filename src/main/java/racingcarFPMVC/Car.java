package racingcarFPMVC;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차의 이름이 5 초과입니다");
        }
        this.name = name;
        this.distance = 0;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}


