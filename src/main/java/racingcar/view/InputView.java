package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Parser;

import java.util.ArrayList;

public class InputView {
    public static String readLine(){
        return Console.readLine();
    }

    public static ArrayList<String> readCarNames(){
        return Parser.parsingByComma(readLine());
    }
}
