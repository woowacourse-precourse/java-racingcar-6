package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.validator.Constants.*;

public class OutputView {
    public static void printResult(){
        System.out.println("실행 결과 ");

    }
    public static void printRoundResult(ArrayList<String> roundResult){
        roundResult.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(List<String> winners){
        System.out.print(WINNER+String.join(",", winners));
    }
}
