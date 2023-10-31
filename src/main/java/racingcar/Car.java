package racingcar;

public class Car {
    private String name;
    private int location = 0;

    public Car(String name) {
        // validateName(name);
        this.name = name;
    }

    private void validateFuel(int fuel) {
        // 리팩토링 요망) 에러메시지가 아닌 함수를 다시실행하게끔
        if (fuel < 0 || fuel > 9) {
            throw new IllegalArgumentException("연료는 0 이상 9 이하의 값이어야 합니다.");
        }
    }

    private void move() {
        location++;
    }

    public void moveOrStop(int fuel) {
        validateFuel(fuel);
        if (fuel >= 4) {
            move();
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
