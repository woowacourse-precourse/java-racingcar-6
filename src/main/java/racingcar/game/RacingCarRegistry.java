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
        int maxPosition = getMaxPosition();
        return racingCars.stream()
                .filter(rc -> rc.getPosition().getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            maxPosition = Math.max(maxPosition, racingCar.getPosition().getPosition());
        }
        return maxPosition;
    }

}
