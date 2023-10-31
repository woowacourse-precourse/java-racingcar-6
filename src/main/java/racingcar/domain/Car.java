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

    public RoundResultDto getCarInfo() {
        return new RoundResultDto(name,location);
    }

    public boolean isSameLocation(int otherLocation) {
        return this.location == otherLocation;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }
}
