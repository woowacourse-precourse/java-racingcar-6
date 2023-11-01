package racingcar.View;

import static racingcar.util.ResultComposer.resultComposer;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.CarModel;

public class OutputView {
    public static void printResult(String input){
        System.out.println(input);
    }

    public static void printWinner(List<CarModel> carModelList) {
        String namesResult = resultComposer(carModelList);
        System.out.println(namesResult);
    }
}
