package racingcar.domain;

public class Car {
    private static final int LENGTH_OF_NAME = 5;

    String name;
    int meter;

    public Car(String name) {
        validateNull(name);
        validateLength(name);
        this.name = name;
        this.meter = 0;
    }

    public void moveOrNot(int randomNumber) {
        if(randomNumber >= 4) {
            meter++;
        }
    }

    private void validateLength(String name) {
        if(name.length() > LENGTH_OF_NAME) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateNull(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException("쉼표(,)를 포함한 이름은 등록할 수 없습니다. 또한, 이름은 최소 1자 이상이어야 합니다.");
        }
    }

}
