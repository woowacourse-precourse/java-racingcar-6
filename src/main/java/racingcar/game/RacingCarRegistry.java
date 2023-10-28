package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.actionnumber.ActionNumberGenerator;

public class RacingCarRegistry {

    private final ActionNumberGenerator actionNumberGenerator;
    private final List<RacingCar> racingCars;
    private MoveOpportunity moveOpportunity;

    public RacingCarRegistry(ActionNumberGenerator actionNumberGenerator,
                             List<RacingCar> racingCars,
                             MoveOpportunity moveOpportunity) {
        this.actionNumberGenerator = actionNumberGenerator;
        this.racingCars = racingCars;

        this.moveOpportunity = moveOpportunity;
    }

    public boolean isRacingOver() {
        return moveOpportunity.isZero();
    }

    public List<RacingCar> move() {
        moveOpportunity = moveOpportunity.move();

        List<RacingCar> racingResults = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            racingCar.move(actionNumberGenerator.generate());
            racingResults.add(new RacingCar(
                    racingCar.getName(),
                    racingCar.getPosition()));
        }

        return racingResults;
    }

    public List<RacingCar> calculateWinner() {
        RacingCar maxPositionCar = getMaxPosition();
        return racingCars.stream()
                .filter(rc -> rc.isSamePosition(maxPositionCar))
                .collect(Collectors.toList());
    }

    private RacingCar getMaxPosition() {
        return racingCars.stream().max(RacingCar::comparePosition).get();
    }

}
