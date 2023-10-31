package basis;

import static constant.Constant.MAXIMUM_RANGE;
import static constant.Constant.MINIMUM_RANGE;
import static constant.Constant.MOVE_CRITERIA;
import static constant.Constant.MOVE_SYMBOL;
import static constant.Constant.STOP_SYMBOL;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class MovingStatus {
    public void printRaceResult(int attemptsNumber, LinkedHashMap<String, String> carNameHashMap) {
        for (int round = 0; round < attemptsNumber; round++) {
            printRoundResult(carNameHashMap);
        }
    }

    private void printRoundResult(LinkedHashMap<String, String> carNameHashMap) {
        for (Entry<String, String> element : carNameHashMap.entrySet()) {
            String move = decideMove();
            String originalValue = element.getValue();
            String newValue = originalValue + move;
            carNameHashMap.put(element.getKey(), newValue);
            System.out.println(element.getKey() + " : " + element.getValue());
        }
        System.out.println();
    }

    private String decideMove() {
        return decideMove(getRandomNumber());
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANGE, MAXIMUM_RANGE);
    }

    private String decideMove(int number) {
        if (number >= MOVE_CRITERIA) {
            return MOVE_SYMBOL;
        }
        return STOP_SYMBOL;
    }
}