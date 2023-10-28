package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingCarDto;

public class RacingCarRegistry {

    private final ActionNumberGenerator actionNumberGenerator;
    private final List<RacingCar> racingCars = new ArrayList<>();
    private final MoveOpportunity moveOpportunity;

    public RacingCarRegistry(ActionNumberGenerator actionNumberGenerator,
                             List<String> names,
                             MoveOpportunity moveOpportunity) {
        this.actionNumberGenerator = actionNumberGenerator;
        for (String name : names) {
            racingCars.add(new RacingCar(new Name(name), new Position()));
        }

        this.moveOpportunity = moveOpportunity;
    }

    public boolean isRacingOver() {
        return moveOpportunity.isZero();
    }

    public List<RacingCarDto> move() {
        moveOpportunity.move();

        List<RacingCarDto> racingCarDtos = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            racingCar.move(actionNumberGenerator.generate());
            racingCarDtos.add(new RacingCarDto(racingCar.getName(), racingCar.getPosition()));
        }

        return racingCarDtos;
    }

    public List<RacingCar> calculateWinner() {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            maxPosition = Math.max(maxPosition, racingCar.getPosition().getPosition());
        }

        int finalMaxPosition = maxPosition;
        return racingCars.stream()
                .filter(rc -> rc.getPosition().getPosition() == finalMaxPosition)
                .collect(Collectors.toList());
    }

}
