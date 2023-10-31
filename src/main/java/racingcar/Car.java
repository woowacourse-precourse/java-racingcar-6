package racingcar;

public class Car {
    private final String name;
    private int raceAccumulation;

    public Car(String name, int raceAccumulation) {
        this.name = name;
        this.raceAccumulation = raceAccumulation;
    }

    public String getName() {
        return name;
    }

    public void increaseRaceAccumulation() {
        raceAccumulation += 1;
    }

    public int getRaceAccumulation() {
        return raceAccumulation;
    }
}
