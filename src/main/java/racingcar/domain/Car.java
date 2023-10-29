package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateCarName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    public void moveOrStop(int number) {
        if(number >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }


}
