package racingcar.model;

public class Car {
    private String name;
    private Integer winCount;

    private Car(String name) {
        this.name = name;
        this.winCount = 0;
    }

    public static Car createCar(String name) {
        return new Car(name);
    }

    public void plusWinCount() {
        this.winCount++;
    }

    public String getName() {
        return name;
    }

    public Integer getWinCount() {
        return winCount;
    }
}
