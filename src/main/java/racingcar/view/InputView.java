package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static List<String> readCarNames(){
        String names = Console.readLine();
        return parseCarNames(names);
    }

    public static List<String> parseCarNames(String names){
        List<String> parseCarNames = Arrays.stream(names.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        Validator.checkCarNameSize(parseCarNames);
        Validator.checkCarNameDuplication(parseCarNames);
        Validator.checkCarNameIsEnglish(parseCarNames);
        return parseCarNames;
    }
}
