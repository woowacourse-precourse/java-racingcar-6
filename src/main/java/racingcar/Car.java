package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public List<String> splitByComma(String inputCarName) {
        return Arrays.asList(inputCarName.split(","));
    }

    public List<Integer> nowRacing(List<String> carNames, int tryNumber) {
        List<String> carMove = initializeCarMove(carNames);

        for (int i = 0; i < tryNumber; i++) {
            System.out.println(i + 1 + "회차");
            goOrStop(carNames, carMove);
        }
        System.out.println();

        return countCarMove(carMove);
    }

    private void goOrStop(List<String> carNames, List<String> carMove) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < carNames.size(); i++) {
            result.append(carNames.get(i));
            result.append(" : ");

            String bar = carMove.get(i);

            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carMove.set(i, bar + "-");
            }

            result.append(bar);
            result.append("\n");
        }
        System.out.println(result);
    }

    private List<String> initializeCarMove(List<String> carNames) {
        List<String> carMove = new ArrayList<>();

        for (String str : carNames) {
            carMove.add("");
        }

        return carMove;
    }

    private List<Integer> countCarMove(List<String> carMove) {
        List<Integer> carMoveDistance = new ArrayList<>();

        for (String str : carMove) {
            carMoveDistance.add(str.length());
        }

        return carMoveDistance;
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
