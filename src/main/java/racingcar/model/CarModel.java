package racingcar.model;

public class CarModel {
    private String name;
    private int forward;

    public CarModel(String name) {
        if (isNameOverLength(name)) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5가 넘습니다.");
        }
        this.name = name;
        this.forward = 0;
    }

    public CarModel(String name, int forward) {
        this.name = name;
        this.forward = forward;
    }

    private boolean isNameOverLength(String name) {
        return name.length() > 5;
    }

    public int increaseForward() {
        this.forward += 1;
        return this.forward;
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.forward);
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }
}
