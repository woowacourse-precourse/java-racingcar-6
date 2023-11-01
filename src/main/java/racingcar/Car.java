package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요.");
        }
        this.name = name;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

