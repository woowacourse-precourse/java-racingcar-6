package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    Validator validator = new Validator();

    public List<String> splitByComma(String inputCarName) {
        List<String> carNames = Arrays.asList(inputCarName.split(","));

        validator.isLengthOverFive(carNames);
        return carNames;
    }

    public List<Integer> nowRacing(List<String> carNames, int tryNumber) {
        List<Integer> carMoveDistance = new ArrayList<>();

        for (int i = 0; i < tryNumber; i++) {
            String bar = goOrStop(carNames);

            System.out.println(bar);

            carMoveDistance.add(bar.length());
        }
        System.out.println();
        return carMoveDistance;
    }

    private String goOrStop(List<String> carNames) {
        StringBuilder bar = new StringBuilder();

        for (String carName : carNames) {
            bar.append(carName);
            bar.append(" : ");

            if (Randoms.pickNumberInRange(0, 9) > 4) {
                bar.append("-");
            }

            bar.append("\n");
        }
        return bar.toString();
    }

    public String printWinner(List<String> carNames, List<Integer> carMoveDistance) {
        int maxDistance = Collections.max(carMoveDistance);
        int indexOfMaxDistance = carMoveDistance.indexOf(maxDistance);
        StringBuilder result = new StringBuilder("최종 우승자 : ");

        result.append(carNames.get(indexOfMaxDistance));
        carMoveDistance.set(indexOfMaxDistance, 0);

        while (maxDistance == Collections.max(carMoveDistance)) {
            indexOfMaxDistance = carMoveDistance.indexOf(maxDistance);

            result.append(", ");
            result.append(carNames.get(indexOfMaxDistance));
            carMoveDistance.set(indexOfMaxDistance, 0);
        }
        return result.toString();
    }
}
