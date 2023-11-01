package racingcar.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private List<String> winnerList = new ArrayList<>();

    public Winner(List<Car> racingCars) {
        int maxPosition = findMaxPosition(racingCars);
        // Car 스트림에서 최대 위치에 있는 모든 자동차만 필터링한 후
        // 자동차 이름으로 매핑된 스트림을 리스트로 수집하여 저장
        winnerList = racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        // winnerList를 변경 불가능한 리스트로 래핑하여 외부 변경 방지
        winnerList = Collections.unmodifiableList(winnerList);
    }

    private int findMaxPosition(List<Car> racingCars) {
        // Car 스트림을 IntStream으로 변환하여 각 자동차의 위치를 가져오고
        // 그 중 최대값을 찾아 반환, 만약 찾을 수 없다면 -1 반환
        return racingCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }

    @Override
    public String toString() {
        // winnerList의 이름을 쉼표로 구분하여 문자열로 반환
        return String.join(", ", winnerList);
    }
}