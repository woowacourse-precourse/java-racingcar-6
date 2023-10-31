package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Parser;
import racingcar.validator.InputValidator;

import java.util.ArrayList;

public class InputView {
    public static String readLine(){
        return Console.readLine();
    }

    public static ArrayList<String> readCarNames(){
        ArrayList<String> carNames = Parser.parsingByComma(readLine());
        // TODO: 리팩토링
        for (String carName : carNames) {
            InputValidator.lessThenFiveLetters(carName);
        }
        return carNames;
    }
}
