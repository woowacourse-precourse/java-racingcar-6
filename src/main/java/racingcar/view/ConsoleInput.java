package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

import static racingcar.validator.AttemptInputValidator.*;
import static racingcar.view.constants.IOType.*;

public class ConsoleInput {

    public static List<Car> carNamesInput() {
        System.out.println(REQUEST_CAR_NAMES_SENTENCE.getSentence());
        String carNames = Console.readLine();
        return parseSentence(carNames);
    }

    public static int attemptsNumberInput() {
        System.out.println(REQUEST_ATTEMPTS_NUMBER_SENTENCE.getSentence());
        return validateAttemptsNumber(Console.readLine());
    }


    private static List<Car> parseSentence(String sentence) {
        sentence = removeAllWhiteSpace(sentence);
        return Arrays.stream(sentence.split(SPLIT_DELIMITER.getSentence()))
                .map(Car::nameOf)
                .toList();
    }

    private static String removeAllWhiteSpace(String sentence) {
        return sentence.replaceAll(REMOVE_WHITE_SPACE_REGEX.getSentence(), "");
    }
}
