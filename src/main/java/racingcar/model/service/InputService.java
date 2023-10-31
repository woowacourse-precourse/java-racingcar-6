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
            if (carNameList.get(i).length() > 5) {
                Console.close();
                throw new IllegalArgumentException("5자리 이상의 차 이름입니다.");
            }
        }
    }

    public Map<String, Integer> convertListToMap(List<String> carNameList) {
        Map<String, Integer> carNameMap = new HashMap<>();
        for (int i = 0; i < carNameList.size(); i++) {
            carNameMap.put(carNameList.get(i), 0);
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
        if (randomNumber > 3) {
            return true;
        }
        return false;
    }
}
