package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.exception.CarsExceptionMessage.ERROR_NAME_DUPLICATED;
import static racingcar.exception.ViewExceptionMessage.*;
import static racingcar.util.CharacterUnits.*;
import static racingcar.view.InputViewMessage.*;

public class InputView {

    public List<String> inputNames() {
        System.out.print(INPUT_NAMES_MESSAGE.getMessage());
        System.out.print(ENTER.getUnit());
        String inputNames = getInput();
        return convertStrToList(inputNames);
    }

    private List<String> convertStrToList(final String inputNames) {
        validateBlank(inputNames);
        List<String> namesList = Arrays.stream(
                        inputNames.split(COMMA.getUnit()))
                                  .toList();
        validateNamesCount(namesList);
        validateNamesFormat(namesList);
        validateDuplicatedName(namesList);
        return namesList;
    }


    public Integer inputCountOfGameRound() {
        System.out.print(INPUT_GAME_ROUND_MESSAGE.getMessage());
        System.out.print(ENTER.getUnit());
        String inputCountOfGameRound = getInput();
        return convertStrToInt(inputCountOfGameRound);
    }

    private Integer convertStrToInt(final String inputCountOfGameRound) {
        validateBlank(inputCountOfGameRound);
        validateNumber(inputCountOfGameRound);
        validateNumberRange(inputCountOfGameRound);
        return Integer.parseInt(inputCountOfGameRound);
    }

    private void validateNumber(final String number) {
        for (char token : number.toCharArray()) {
            validateEachDigit(token);
        }
    }

    private void validateEachDigit(final char token) {
        if (!Character.isDigit(token)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(final String numberStr) {
        int number = Integer.parseInt(numberStr);
        if (number < 1) {
            throw new IllegalArgumentException(ERROR_GAME_ROUND_SMALL_THAN_ONE.getMessage());
        }
    }

    private void validateBlank(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_GAME_ROUND_BLANK.getMessage());
        }
    }

    private void validateNamesCount(final List<String> nameList) {
        if (nameList.size() <= 1) {
            throw new IllegalArgumentException(ERROR_NAMES_SMALL_THAN_TWO.getMessage());
        }
    }

    private void validateNamesFormat(final List<String> nameList) {
        for (String name : nameList) {
            validateNameFormat(name);
        }
    }

    private void validateNameFormat(final String name) {
        for (char token : name.toCharArray()) {
            validateEachLetter(token);
        }
    }

    private void validateEachLetter(final char token) {
        if (!Character.isLetter(token)) {
            throw new IllegalArgumentException(ERROR_NOT_LETTER.getMessage());
        }
    }

    private void validateDuplicatedName(final List<String> names) {
        if (names.stream()
                .collect(Collectors.toSet())
                .size() != names.size()) {
            throw new IllegalArgumentException(ERROR_NAME_DUPLICATED.getMessage());
        }
    }


    private String getInput() {
        return Console.readLine();
    }
}
