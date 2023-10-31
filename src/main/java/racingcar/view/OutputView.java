package racingcar.view;

import racingcar.model.Car;
import java.util.List;

public class OutputView {

    private static final String ONE_CYCLE_RESULT = "\n실행 결과";
    private static final String PRINT_FORWARD = "-";
    private static final String FINAL_WINNERS = "최종 우승자 : ";

    public void printOneCycleResultMessage() {
        System.out.println(ONE_CYCLE_RESULT);
    }

    public void printNextLine() {
        System.out.println();
    }

    public void printCurrentLocation(Car car) {
        int repeatNumber = car.forwardCount;
        System.out.print(car.name + " : ");
        for (int i = 0; i < repeatNumber; i++) {
            System.out.print(PRINT_FORWARD);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print(FINAL_WINNERS);
        String result = String.join(", ", winners);
        System.out.println(result);
    }


}