package racingcar.dto;

import racingcar.domain.RacingCar;
import racingcar.domain.condition.MoveCondition;

public class RacingCarDto {

    private String carName;
    private int position;

    public RacingCarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static RacingCarDto valueOf(RacingCar racingCar) {
        return new RacingCarDto(racingCar.carName(), racingCar.position());
    }

    public RacingCar toRacingCar() {
        return new RacingCar(this.carName, this.position, new MoveCondition());
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
