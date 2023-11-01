package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

import static racingcar.validator.AttemptInputValidator.*;
import static racingcar.view.constants.IOType.*;
import static racingcar.validator.CarInputValidator.*;

public class ConsoleInput {

    public static List<Car> carNamesInput() {
        System.out.println(REQUEST_CAR_NAMES_SENTENCE.getText());
        String carNames = Console.readLine();
        return parseSentence(carNames);
    }

    public static int attemptsNumberInput() {
        System.out.println(REQUEST_ATTEMPTS_NUMBER_SENTENCE.getText());
        int attemptsNumber = validateAttemptsNumber(Console.readLine());
        Console.close();
        return attemptsNumber;
    }


    private static List<Car> parseSentence(String sentence) {
        sentence = removeAllWhiteSpace(sentence);
        List<Car> carList = Arrays.stream(sentence.split(SPLIT_DELIMITER.getText()))
                .map(Car::nameOf)
                .toList();
        duplicateNameValidate(carList);
        return carList;
    }

    private static String removeAllWhiteSpace(String sentence) {
        return sentence.replaceAll(REMOVE_WHITE_SPACE_REGEX.getText(), "");
    }
}
