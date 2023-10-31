package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PaceComputer {
    private static final int INITIAL_RANDOM_NUMBER = 0;
    private static final int LAST_RANDOM_NUMBER = 9;
    private static final int HURDLE_NUMBER_TO_DRIVE = 4;
    private final List<Integer> randomNumberList = new ArrayList<>();
    private boolean isManualRandomNumber;
    private int randomNumber;

    public PaceComputer() {
    }

    public PaceComputer(boolean isManualRandomNumber, int randomNumber) {
        this.isManualRandomNumber = isManualRandomNumber;
        this.randomNumber = randomNumber;
    }

    public LinkedHashMap<String, Integer> createDefaultPaceMap(Cars cars) {
        List<String> carNameList = cars.getCarNameList();

        return carNameList
                .stream()
                .collect(Collectors
                        .toMap(
                        carName -> carName,
                        driveSuccessNumber -> 0,
                        (oldValues, newValues) -> oldValues,
                        LinkedHashMap::new
                ));
    }

    public void updatePaceMap(LinkedHashMap<String, Integer> paceMap) {
        paceMap.forEach((carName, driveSuccessNumber) -> {
            if (!isManualRandomNumber) {
                randomNumber = pickNumberInRange(INITIAL_RANDOM_NUMBER, LAST_RANDOM_NUMBER);
            }

            if (randomNumber >= HURDLE_NUMBER_TO_DRIVE) {
                paceMap.put(carName, driveSuccessNumber + 1);
            }
            randomNumberList.add(paceMap.get(carName));
        });
    }

    public List<Integer> getRandomNumberList() {
        return randomNumberList;
    }
}