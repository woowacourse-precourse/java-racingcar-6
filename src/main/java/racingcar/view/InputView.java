package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static List<String> readCarNames(){
        String names = readLine();
        return parseCarNames(names);
    }

    public static int readCountNumber(){
        String number = Console.readLine();
        return parseTryCountNumber(number);
    }

    private static int parseTryCountNumber(String number) {
        Validator.checkTryCountNumber(number);
        return Integer.parseInt(number);
    }

    public static List<String> parseCarNames(String names){
        List<String> parseCarNames = Arrays.stream(names.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        Validator.checkCarNameLength(parseCarNames);
        Validator.checkCarNameSize(parseCarNames);
        Validator.checkCarNameDuplication(parseCarNames);
        Validator.checkCarNameIsEnglish(parseCarNames);
        return parseCarNames;
    }
}
