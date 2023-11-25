package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.domain.Cars;
import racingcar.domain.Rounds;

public class InputView {
    public Cars getCarsInput() {
        String cars = Console.readLine();
        List<String> list = convertToList(cars);
        validateCarInput(list);
        System.out.println(list);
        System.out.println("size: " + list.size());
        return new Cars(list);
    }

    public Rounds getRoundsInput() {
        String input = Console.readLine();
        int rounds = parseInt(input);
        validateRoundsInput(rounds);
        return new Rounds(rounds);
    }

    public void validateCarInput(List<String> list) {
        if (!isLengthWithinLimit(list)) {
            throw new IllegalArgumentException();
        }
        if (!isEnglish(list)) {
            throw new IllegalArgumentException();
        }
        if (!isNoEmptySpace(list)) {
            throw new IllegalArgumentException();
        }
        if (!isUnique(list)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isLengthWithinLimit(List<String> list) {
        for (String element : list) {
            if (element.length() < 1 || element.length() > 5) {
                return false;
            }
        }
        return true;
    }

    private boolean isEnglish(List<String> list) {
        String englishPattern = "^[a-zA-Z]*$";
        for (String element : list) {
            if (!(Pattern.matches(englishPattern, element))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNoEmptySpace(List<String> list) {
        for (String element : list) {
            if (element.contains(" ")) {
                return false;
            }
        }
        return true;
    }

    private boolean isUnique(List<String> list) {
        HashSet<String> set = new HashSet<>(list);
        if (set.size() != list.size()) {
            return false;
        }
        return true;
    }

    public List<String> convertToList(String input) {
        String[] array = input.split(",");
        return Arrays.asList(array);
    }

    private Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void validateRoundsInput(int input) {
        if (!isBetweenLimit(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isBetweenLimit(int input) {
        if (input < 1 || input > 100) {
            return false;
        }
        return true;
    }
}
