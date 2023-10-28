package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingCarDto;
import racingcar.dto.RacingResultDto;

public class RacingCarRegistry {

    private final ActionNumberGenerator actionNumberGenerator;
    private final List<RacingCar> racingCars = new ArrayList<>();
    private final MoveCount moveCount;

    public RacingCarRegistry(ActionNumberGenerator actionNumberGenerator,
                             List<String> names,
                             MoveCount moveCount) {
        this.actionNumberGenerator = actionNumberGenerator;
        for (String name : names) {
            racingCars.add(new RacingCar(new Name(name), new Position()));
        }

        this.moveCount = moveCount;
    }

    public boolean isRacingOver() {
        return moveCount.isZero();
    }

    public RacingResultDto move() {
        moveCount.move();

        List<RacingCarDto> racingCarDtos = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            racingCar.move(actionNumberGenerator.generate());
            racingCarDtos.add(new RacingCarDto(racingCar.getName(), racingCar.getPosition()));
        }

        return new RacingResultDto(racingCarDtos);
    }
}
