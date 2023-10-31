package racingcar.view;

import racingcar.model.Car;

public class OutputView {

    private static final String ONE_CYCLE_RESULT = "\n실행 결과";
    private static final String PRINT_FORWARD = "-";

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


}
