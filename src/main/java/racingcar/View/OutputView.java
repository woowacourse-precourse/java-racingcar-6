package racingcar.View;

import racingcar.Model.CarModel;

import java.util.List;

import static racingcar.util.ResultComposer.resultComposer;

public class OutputView {
    public static void printResult(String input){
        System.out.println(input);
    }

    public static void printWinner(List<CarModel> carModelList) {
        String namesResult = resultComposer(carModelList);
        System.out.println(namesResult);
    }

}
