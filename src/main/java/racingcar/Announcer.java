package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Announcer {

    public void sayEnterCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void sayEnterAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void sayIntroPlayResult() {
        System.out.println("실행 결과");
    }

    public void sayCarPosition(Car car) {
        System.out.println(car.getName() + " : " + car.getPositionBar());
    }

    public void sayWinner(List<Car> cars) {
        Integer highestPosition = getHighestPosition(cars);

        String winners = getWinners(cars, highestPosition);

        System.out.println("최종 우승자 : " + winners);
    }

    private Integer getHighestPosition(List<Car> cars) {
        return Collections.max(
                cars.stream()
                        .map(Car::getPosition)
                        .toList()
        );
    }

    private String getWinners(List<Car> cars, Integer highestPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == highestPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
