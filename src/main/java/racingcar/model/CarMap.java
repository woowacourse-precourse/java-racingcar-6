package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarMap {
    private final Map<String, RacingCar> carMap;

    public CarMap() {
        carMap = new LinkedHashMap<>();
    }

    /**
     * 이름을 입력 받아 Map에 RacingCar와 매핑한다.
     *
     * @param name 자동차에 붙일 이름
     */
    public void add(String name) {
        carMap.put(name, new RacingCar());
    }

    /**
     * 각 자동차들이 라운드를 진행하게한다.
     */
    public void excuteRound() {
        for (Map.Entry<String, RacingCar> carEntry : carMap.entrySet()) {
            RacingCar racingCar = carEntry.getValue();
            racingCar.excuteRound();
        }
    }

    /**
     * 우승한 자동차들의 리스트를 뽑아낸다.
     *
     * @return 우승한 자동차들의 이름 리스트
     */
    public List<String> getWinners() {
        int maxDistance = getMaxDistance();

        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, RacingCar> entry : carMap.entrySet()) {
            RacingCar car = entry.getValue();
            if (car.getDistance() == maxDistance) {
                winners.add(entry.getKey());
            }
        }

        return winners;
    }

    private int getMaxDistance() {
        int maxDistance = 0;

        for (RacingCar car : carMap.values()) {
            int distance = car.getDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }
}
