package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarMotionController {
    public static String carMotion(int randomNumber) {
        if (randomNumber >= 4) {
            return "-";
        }
        return "";
    }

    public static List<String> findWinners(Map<String, Integer> carHashMap) {
        List<String> winners = new ArrayList<>();
        int maxMovement = -1;
        for (Map.Entry<String, Integer> entry : carHashMap.entrySet()) {
            String carName = entry.getKey();
            int movementLength = entry.getValue();
            if (movementLength > maxMovement) {
                // 새로운 우승자 발견
                winners.clear();
                winners.add(carName);
                maxMovement = movementLength;
            } else if (movementLength == maxMovement) {
                // 우승자 중에 추가
                winners.add(carName);
            }
        }
        return winners;
    }
}
