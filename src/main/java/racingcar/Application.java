package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Car> carList = new ArrayList<>();

        RacingGameInput racingGameInput = new RacingGameInput();
        RacingGameCalculator racingGameCalculator = new RacingGameCalculator();
        RacingGamePrinter racingGamePrinter = new RacingGamePrinter();

        carList = racingGameInput.getCarNameInput(carList);
        int tryNumber = racingGameInput.getTryNumberInput();

        System.out.println();
        System.out.println("실행 결과");

        for(int i=0; i<tryNumber; i++) {
            carList = racingGameCalculator.calculateEachResult(carList);
            racingGamePrinter.printEachResult(carList);
        }

        racingGamePrinter.printFinalResult(carList);
    }
}
