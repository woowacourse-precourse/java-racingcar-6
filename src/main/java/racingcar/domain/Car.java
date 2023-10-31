package racingcar.domain;

import racingcar.dto.response.RoundResultDto;

public class Car {
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        location += 1;
    }

    public RoundResultDto nameAndLocation() {
        return new RoundResultDto(name, location);
    }

    public boolean isSameLocation(int otherLocation) {
        return this.location == otherLocation;
    }

    public String name() {
        return this.name;
    }

    public int location() {
        return this.location;
    }
}
