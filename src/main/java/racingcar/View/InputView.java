package racingcar.View;

import racingcar.Constants.InputExceptionConstants;
import racingcar.Constants.Prompts;
import racingcar.Car.Car;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;


public class InputView {
    public static List<Car> promptCarNames() {
        System.out.println(Prompts.PROMPT_CAR_NAMES);
        String input = Console.readLine();
        return createCarsList(input);
    }
    public static List<Car> createCarsList(String input) {
        List<Car> carsList = new ArrayList<>();
        Set<String> carNamesSet = new HashSet<>();

        String[] names = input.split(Prompts.SPLIT_DELIMITER, -1);

        for (String name : names) {
            String trimmedName = name.trim();

            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException();
            }

            if (trimmedName.length() > InputExceptionConstants.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }

            if (!carNamesSet.add(trimmedName)) {
                throw new IllegalArgumentException();
            }

            carsList.add(new Car(trimmedName));
        }

        return carsList;
    }

    public static int promptNumber() {
        System.out.println(Prompts.PROMPT_TRIAL_COUNT);
        String input = Console.readLine();
        return parseNumber(input);
    }

    public static int parseNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < InputExceptionConstants.MIN_TRIAL_COUNT) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


}
