package racingcar.service.movement;

import racingcar.output.ServicePrinter;

public class MovementStatus {
    public static int[] race(String[] names, int count) {
        int[] countsByName = new int[names.length];
        while(count-- > 0) {
            RacingCarController.moveCars(countsByName);
            ServicePrinter.printRaceStatus(names, countsByName);
        }
        return countsByName;
    }
}
