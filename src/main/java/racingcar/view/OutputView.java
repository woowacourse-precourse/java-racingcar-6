package racingcar.view;

import java.util.List;

import racingcar.model.Car;

public class OutputView {
    /**
     * View는 모델에 의존할 수 있다. 즉 코드가 있어도 된다. 하지만 Controller코드는 있으면 안된다. 또한 Model의 정보는 Controller를 통해 받아야한다.
     */
    private static final String ONE_STEP = "-";

    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printLoopSetMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printFirstResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRaceStatusMessage(Car car) {
        System.out.println(car.getName() + " : " + ONE_STEP.repeat(car.getCurrentPosition()));
    }

    public void printSpaceMessage() {
        System.out.println();
    }

    public void printWinnerResultMessage(List<String> jointWinner) {
        String result = String.join(", ", jointWinner);
        System.out.println("최종 우승자 : " + result);
    }
}
