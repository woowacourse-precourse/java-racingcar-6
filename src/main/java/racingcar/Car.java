package racingcar;

public class Car {
    private String name;
    private int position = 0;
    public Car (String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException("자동차의 이름이 잘못되었습니다.");
        this.name = name;
    }
    public String getCarName () {
        return this.name;
    }
    public int getCarPosition () {
        return this.position;
    }
    public void updatePosition (int randomValue) {
        if (randomValue >= 4)
            this.position += 1;
    }
}
