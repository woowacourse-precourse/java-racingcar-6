package racingcar.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Round {

    private final Map<Car, String> carScoreMap;
    private boolean isFinished;
    private String DONE;

    public Round() {
        carScoreMap = new LinkedHashMap<Car, String>();
        isFinished = false;
    }

    /**
     * 게임에 참여하는 레이싱카 리스트와 총 회차를 저장하는 초기화 함수
     * @param carList
     * @param cnt
     */
    public void init(List<Car> carList, int cnt) {
        carList.forEach(car -> carScoreMap.put(car, ""));
        DONE = "-".repeat(cnt);
    }

    public void play() {
        reset();
        for (Car car : carScoreMap.keySet()) {
            int num = car.extract();
            String result = car.advance(num);

            if (result.equals(DONE)) {
                isFinished = true;
            }
            carScoreMap.replace(car, result);
        }
    }

    private void reset() {
        carScoreMap.keySet().forEach(car -> carScoreMap.put(car, ""));
    }

    /**
     * 우승자 명단을 배열에 추가하여 반환
     * @return
     */
    public List<String> victory() {

        List<String> victoryList = new ArrayList<>();

        if (isFinished) {
            victoryList = carScoreMap.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(DONE))
                    .map(entry -> entry.getKey().getName())
                    .collect(Collectors.toList());
        }

        return victoryList;
    }

    public Map<String, String> saveResult() {
        return carScoreMap.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey().getName(), Map.Entry::getValue));
    }
}
