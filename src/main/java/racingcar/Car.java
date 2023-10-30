package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public int getPosition() {
        return position;
    }
    public String getName() { return name; }

    public void move() {
        position++;
    }

    public void printCurrentPosition() {
        System.out.println(name + " : " + "-".repeat(position));
    }

    private void validateCarName(String carName) {
        if(carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
