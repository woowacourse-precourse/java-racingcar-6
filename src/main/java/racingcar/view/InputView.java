package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;

import java.util.List;

public class InputView {

    public static List<String> readCarNames(){
        String names = Console.readLine();
        return parseCarNames(names);
    }

    public static List<String> parseCarNames(String names){
        List<String> parseCarNames = List.of(names.split(","));
        Validator.checkCarNameSize(parseCarNames);
        Validator.checkCarNameDuplication(parseCarNames);
        return parseCarNames;

    }
}
