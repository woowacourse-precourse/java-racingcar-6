package racingcar.output;

import java.util.List;
import racingcar.Car;

public class ConsoleOutput implements Output {

    @Override
    public void printGuideTextForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void printGuideTextForExecutionCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void printExecutionResult(List<Car> carList) {

    }

    @Override
    public void printWinner(List<Car> carList) {

    }
}
