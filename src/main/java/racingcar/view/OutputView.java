package racingcar.view;

import java.util.List;

import racingcar.model.Car;

public class OutputView {
    /**
     * View는 모델에 의존할 수 있다. 즉 코드가 있어도 된다. 하지만 Controller코드는 있으면 안된다.
     * 또한 Model의 정보는 Controller를 통해 받아야한다.
     */
    private static final String ONE_STEP = "-";

    public void printFirstResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRaceStatusMessage(Car car) {
        System.out.println(car.getName() + " : " + ONE_STEP.repeat(car.getCurrentPosition()));
    }

    public void printWinnerResult(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    public void printJointWinnerResult(List<String> jointWinner) {
        String result = String.join(", ", jointWinner);
        System.out.println("최종 우승자 : " + result);
    }
}
