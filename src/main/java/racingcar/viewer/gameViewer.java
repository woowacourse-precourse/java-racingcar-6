package racingcar.viewer;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class GameViewer {
    private static final String STEP = "-";
    public void printAskCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAskTheNumberOfTry() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printStartMessage() {
        System.out.println("실행 결과");
    }

    public void printRaceState(List<Car> cars) {
        for (Car car : cars) {
            String steps = "";
            for (int i = 0; i < car.getStep(); i++) {
                steps += STEP;
            }
            System.out.println(car.getName() + " : " + steps);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        List<String> names = new ArrayList<>();
        for (Car car : winners) {
            names.add(car.getName());
        }
        System.out.println("최종 우수자 : " + String.join(", ", names));
    }

}
