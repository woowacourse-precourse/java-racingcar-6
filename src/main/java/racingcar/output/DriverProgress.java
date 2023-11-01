package racingcar.output;

import racingcar.service.RacingCarController;

public class DriverProgress {
    public static int[] race(String[] names, int count) {
        int[] countsByName = new int[names.length];
        while(count-- > 0) {
            moveCars(countsByName);
            ServicePrinter.printRaceStatus(names, countsByName);
        }
        return countsByName;
    }

    private static void moveCars(int[] countsByName) {
        for(int t = 0; t < countsByName.length; t++) {
            if(RacingCarController.isMoveForward()) {
                countsByName[t]++;
            }
        }
    }



}
