package racingcar;

public class RCar {
    private String name;
    private int forwardCount;

    public RCar(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자에서 5자까지 가능합니다.");
        }
        this.name = name;
        this.forwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        forwardCount = forwardCount + 1;
        return forwardCount;
    }

    public void updateforwardCount() {

    }
}