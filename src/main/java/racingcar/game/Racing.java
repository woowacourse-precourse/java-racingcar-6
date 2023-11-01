package racingcar.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private List<Car> racingCars;

    public Racing(String carNames) {
        // carNames 문자열을 쉼표로 분리하고
        // 각 이름을 Car 객체로 변환한 뒤
        // 리스트로 수집하여 racingCars 초기화
        racingCars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getRacingCars() {
        // racingCars의 불변 복사본을 반환하여 외부에서의 수정 방지
        return Collections.unmodifiableList(racingCars);
    }

    public void moveAllCarsForward() {
        // 각 자동차에 대하여 움직일 수 있는지 확인하고 움직임 처리
        // 움직일 수 있다면 자동차를 전진시키고 반환 아니라면 현재 상태 그대로 반환
        // 결과를 리스트로 수집하여 racingCars 업데이트
        racingCars = racingCars.stream()
                .map(car -> {
                    if (car.isMovable()) {
                        return car.moveForward();
                    }
                    return car;
                })
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        // 모든 자동차의 상태 문자열을 개행문자로 결합하여 레이싱 현황 문자열을 반환
        String racingStatus = racingCars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"))
                + "\n";
        return racingStatus;
    }
}