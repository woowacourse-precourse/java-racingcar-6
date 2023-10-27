package racingcar.vo;

public final class Car {
    private final String name;
    private final Integer score;

    public Car(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public Car makeNewCar() {
        return new Car(this.name, this.score + 1);
    }
}
