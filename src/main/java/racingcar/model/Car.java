package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length()>5) {
            throw new IllegalArgumentException("이름의 길이는 5자 이하 여야 합니다.");
        }
        this.name = name;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber>=4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getCarStatus() {
        return name + " : " + "-".repeat(position);
    }

}
