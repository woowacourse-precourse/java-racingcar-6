package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputHandler {

    public void printStartMessages() {
        String result = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        System.out.println(result);
    }

    public void printAskRounds() {
        String result = "시도할 회수는 몇회인가요?";
        System.out.println(result);
    }

    public void printRunResult() {
        String result = "실행 결과";
        System.out.println(result);
    }

    public StringBuilder buildCarResult(String name, int distance) {
        StringBuilder result = new StringBuilder();
        result.append(name + " : ");

        for (int i = 0; distance > i; i++) {
            result.append("-");
        }

        return result;
    }

    public void printResults(List<Car> cars) {
        StringBuilder result = new StringBuilder();

        for (Car car : cars) {
            result.append(buildCarResult(car.getName(), car.getDistance()));
            result.append('\n');
        }
        result.append('\n');

        System.out.println(result);
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.getName());
        }

        String result = "최종 우승자 : " + String.join(", ", winnerNames);
        System.out.println(result);
    }
}
