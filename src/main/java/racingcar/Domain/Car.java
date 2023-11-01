package racingcar.Domain;

public class Car {
    private String name;
    private Long position;

    public Car(String name) {
        this.name = name;
        this.position = 0L;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public Long getPosition() {
        return position;
    }
}
