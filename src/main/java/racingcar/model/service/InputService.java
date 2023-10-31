package racingcar.model.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import racingcar.model.domain.Car;

public class InputService {
    private static final int MOVING_FORWARD = 4;
    private static final int OVER_LENGTH = 5;

    public Map<String, Integer> validateCarName(String carName) {
        StringTokenizer st = new StringTokenizer(carName, ",");
        List<String> carNameList = new ArrayList<String>();

        do {
            carNameList.add(st.nextToken());
            if (!st.hasMoreTokens()) {
                break;
            }
        } while (true);

        checkLengthCarName(carNameList);
        return convertListToMap(carNameList);
    }

    public void checkLengthCarName(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            if (carNameList.get(i).length() > OVER_LENGTH) {
                Console.close();
                throw new IllegalArgumentException("5자리 이상의 차 이름입니다.");
            }
        }
    }

    public Map<String, Integer> convertListToMap(List<String> carNameList) {
        Map<String, Integer> carNameMap = new HashMap<>();

        for (int i = 0; i < carNameList.size(); i++) {
            String carName = carNameList.get(i);
            carNameMap.put(carName, 0);
        }
        return carNameMap;
    }

    public int validateNumberOfAttempts(String numberOfAttempts) {
        try {
            int number = Integer.parseInt(numberOfAttempts);
            return number;
        } catch (IllegalArgumentException e) {
            Console.close();
            throw new IllegalArgumentException();
        }
    }

    public void doRace(Car car) {
        Map<String, Integer> carName = car.getName();
        Iterator<String> keys = carName.keySet().iterator();

        while (keys.hasNext()) {
            String key = keys.next();
            int carValue = carName.get(key);

            if (goOrStop()) {
                carName.put(key, carValue + 1);
            }
        }
    }

    public boolean goOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MOVING_FORWARD) {
            return true;
        }
        return false;
    }

    public String choiceWinner(Car car) {
        String winnerName = "";
        Map<String, Integer> carName = car.getName();
        int max;

        max = carName.values().stream() // car의 가장 큰 값을 찾는다.
                .max(Integer::compareTo)
                .orElse(0);

        for (Map.Entry<String, Integer> entry : carName.entrySet()) {
            if (entry.getValue() == max) {
                winnerName += entry.getKey() + ", ";
            }
        }
        winnerName = splitToken(winnerName);
        return winnerName;
    }

    public String splitToken(String winnerName) {
        if (winnerName.endsWith(", ")) { // 마지막에 (, )가 있으면 제거하고 반환한다.
            winnerName = winnerName.substring(0, winnerName.length() - 2);
        }
        return winnerName;
    }
}
