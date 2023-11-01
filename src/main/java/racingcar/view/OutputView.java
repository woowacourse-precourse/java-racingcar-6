package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printResult(Car car) {
        System.out.println(car.getName() + " : " + car.getResult());
    }

    public void printFinalResult(List<String> result) {
        System.out.print("\n최종 우승자 : ");

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(",");
            }
        }
    }

}
