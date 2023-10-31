package racingcar.view;

import static racingcar.view.constants.IOType.REMOVE_WHITE_SPACE_REGEX;
import static racingcar.view.constants.IOType.REQUEST_CAR_NAMES_SENTENCE;
import static racingcar.view.constants.IOType.SPLIT_DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class ConsoleInput {

    public static List<Car> carNamesInput() {
        System.out.println(REQUEST_CAR_NAMES_SENTENCE);
        String carNames = Console.readLine();
        return parseSentence(carNames);
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
