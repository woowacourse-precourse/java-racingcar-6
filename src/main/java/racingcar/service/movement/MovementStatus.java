package racingcar.service.movement;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.output.ServicePrinter;
import racingcar.service.movement.RacingCarController.MovementStrategy;

public class MovementStatus {
    private final RacingCarController racingCarController;

    public MovementStatus(MovementStrategy movementStrategy) {
        this.racingCarController = new RacingCarController(movementStrategy);
    }

    public int[] race(String[] names, int count) {
        int[] countsByName = new int[names.length];
        while(count-- > 0) {
            racingCarController.moveCars(countsByName);
            ServicePrinter.printRaceStatus(names, countsByName);
        }
        return countsByName;
    }

    public static class RandomMovementStrategy implements MovementStrategy {
        @Override
        public boolean shouldMove() {
            return Randoms.pickNumberInRange(0, 9) >= 4;
        }
    }

}
