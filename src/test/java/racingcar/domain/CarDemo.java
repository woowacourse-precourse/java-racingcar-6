package racingcar.domain;

public class CarDemo {
    private final String name;
    private int position;

    public CarDemo(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position += 1;
        }
    }
}
