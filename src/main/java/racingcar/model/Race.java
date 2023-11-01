package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.Cars;

public class Race {
    final static int MORE = 4;

    public Race(List<String> cars, int maxTry) {
        int tryCount = 0;
        int car_numbers = cars.size();
        int carsLocation[] = new int[car_numbers];
        while (tryCount < maxTry) {
            racing(carsLocation);
        }
    }

    private static int[] racing(int currentCarLocation[]) {
        int MaxCarNumber = currentCarLocation.length;
        for (int CarNumber = 0; CarNumber < MaxCarNumber; CarNumber++) {
            if (forwardCondition())
                currentCarLocation[CarNumber]++;
        }
        return currentCarLocation;
    }

    private static boolean forwardCondition() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= MORE)
            return true;
        return false;
    }
}
