package racingcar.view;

import racingcar.domain.Car;
import racingcar.util.Constant;

import java.text.MessageFormat;
import java.util.List;

public class OutputView {

    public static void printResultText(){
        System.out.println(Constant.NEW_LINE+ Constant.RESULT_TEXT);
    }

    public static void printResult(List<Car> carList){
        for (Car car : carList) {
            System.out.println(MessageFormat.format(Constant.CAR_RESULT_FORMAT, car.getName(), car.getScore()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winner){
        System.out.println(Constant.WINNER+ String.join(", ", winner));
    }
}
