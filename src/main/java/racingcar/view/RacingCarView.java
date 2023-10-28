package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.race.RaceResult;

import java.util.List;
import java.util.StringJoiner;

public class RacingCarView {
    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMessage(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        sb.append("실행 결과\n");
        for (Car car : cars) {
            sb.append(getCarStatusLabel(car));
        }
        sb.append('\n');

        System.out.println(sb);
    }

    public void printWinnerMessage(RaceResult raceResult) {
        System.out.println("최종 우승자 : " + raceResult.getWinnerNames());
    }

    private String getCarStatusLabel(Car car) {
        return String.format("%s : %s", car.getName(), "-".repeat(car.getPosition()));
    }
}
