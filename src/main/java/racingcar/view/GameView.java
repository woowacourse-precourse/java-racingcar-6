package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.car.Car;

public class GameView {
    public void printCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountInput() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private String getCarResult(Car car) {
        return String.format("%s : %s", car.getName(), "-".repeat(car.getPosition()));
    }

    public void printRoundResult(List<Car> cars) {
        StringJoiner stringJoiner = new StringJoiner("\n");

        stringJoiner.add("실행 결과");

        for (Car car : cars) {
            stringJoiner.add(getCarResult(car));
        }
        stringJoiner.add("");

        System.out.println(stringJoiner);
    }

    public void printWinner(List<String> raceResult) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (String result : raceResult) {
            stringJoiner.add(result);
        }
        System.out.println("최종 우승자 : " + stringJoiner);
    }
}
