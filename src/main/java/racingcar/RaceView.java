package racingcar;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarDto;

public final class RaceView {
    public static String printGuideRaceCarInput() {
        return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    }

    public static String printGuideRoundInput() {
        return "시도할 회수는 몇회인가요?";
    }

    public static String printCarsStatus(List<Car> cars) {
        StringBuilder carsStatus = new StringBuilder();
        for (Car car : cars) {
            carsStatus.append(car.toString() + "\n");
        }
        return carsStatus.toString();
    }

    public static String printGuideResult() {
        return "실행 결과";
    }

    public static String printWinners(CarDto winners) {
        StringBuilder winnerGuide = new StringBuilder("최종 우승자 : ");
        winnerGuide.append(winners.carNames());
        return winnerGuide.toString();
    }
}
