package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarService {
    Map<String, String> forwardMap = new HashMap<>();

    public void getCars() {
        String carNames = Console.readLine();
        for (String car : carNames.split(",")) {
            String carName = car.trim();
            if (carName.length() > 5 || forwardMap.containsKey(carName)) {
                throw new IllegalArgumentException();
            }
            forwardMap.put(carName, "");
        }
    }

    int getMove() {
        return Integer.parseInt(Console.readLine());
    }

    void move() {
        for (String car : forwardMap.keySet()) {
            System.out.print(car + " : ");
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                forwardMap.put(car, forwardMap.get(car) + "-");
            }
            System.out.println(forwardMap.get(car));
        }
        System.out.println();
    }

    String getWinners() {
        int max = Integer.MIN_VALUE;
        List<String> winners = new ArrayList<>();
        for (String car : forwardMap.keySet()) {
            int forward = forwardMap.get(car).length();
            if (forward > max) {
                max = forward;
                winners.clear();
                winners.add(car);
            } else if (forward == max) {
                winners.add(car);
            }
        }

        return String.join(", ", winners);
    }
}
