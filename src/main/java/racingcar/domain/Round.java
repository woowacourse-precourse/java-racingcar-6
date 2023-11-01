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
    private List<String> victoryList;

    public Round() {
        carScoreMap = new LinkedHashMap<Car, String>();
        isFinished = false;
        victoryList = new ArrayList<>();
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

    /**
     * 모든 차량에 대해 전진 or 중지를 실행하는 메서드
     * - 매 라운드마다 각 차량은 추출한 랜덤 수에 따라 전진하거나 중지한다
     */
    public void play() {
//        reset();
        for (Car car : carScoreMap.keySet()) {
            int num = car.extract();
            String result = car.advance(num);

            if (result.equals(DONE)) {
                isFinished = true;
            }
            carScoreMap.replace(car, result);
        }
    }

    /**
     * 우승자 명단을 배열에 추가하여 반환하는 메서드
     * - 우승자가 없다면 isEmpty()의 결과가 true이다
     * @return
     */
    public List<String> victory() {
        if (isFinished) {
            victoryList = carScoreMap.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(DONE))
                    .map(entry -> entry.getKey().getName())
                    .collect(Collectors.toList());
        }

        return victoryList;
    }

    /**
     * 출력할 결과를 반환하는 메서드
     * - <Car, String> 의 차량 객체와 점수를 저장하고 있는 Map에서
     * <String, String>과 같이 이름과 점수만을 추출하여 결과 Map으로 반환한다
     * @return
     */
    public Map<String, String> saveResult() {
        return carScoreMap.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey().getName(), Map.Entry::getValue));
    }
}
