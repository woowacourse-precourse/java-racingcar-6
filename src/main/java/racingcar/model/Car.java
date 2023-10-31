package racingcar.model;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }
    
    // 테스트 코드용 생성자
    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            this.distance += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
