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
}
