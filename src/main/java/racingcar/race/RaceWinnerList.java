package racingcar.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RaceWinnerList {

    private static final int EQUAL = 0;
    private static final int LESS_THAN = -1;

    private final List<RaceCar> winnerList;

    public RaceWinnerList(RaceCars carList) {
        winnerList = createWinnerList(carList);
    }

    private List<RaceCar> createWinnerList(RaceCars carList) {
        List<RaceCar> winnerList = new ArrayList<>();
        Iterator<RaceCar> iterator = carList.getIterator();

        RaceCar firstCar = iterator.next();
        winnerList.add(firstCar);

        while (iterator.hasNext()) {
            RaceCar raceCar = iterator.next();
            if (firstCar.compareTo(raceCar) == EQUAL) {
                winnerList.add(raceCar);
                continue;
            }
            if (firstCar.compareTo(raceCar) == LESS_THAN) {
                winnerList.clear();
                firstCar = raceCar;
                winnerList.add(raceCar);
            }
        }

        return Collections.unmodifiableList(winnerList);
    }

    public Iterator<RaceCar> getIterator() {
        return winnerList.iterator();
    }
}