package racingcar.handler;

import java.util.*;

import static racingcar.constants.ExceptionMessageConstants.*;

public class InputHandler {

    private static final int MAX_LENGTH = 5;
    private static final String NAME_DELIMITER = ",";

    public List<String> toNameList(String names) {
        validateNull(names);

        List<String> nameList = convertToNameList(names);

        validateNameList(nameList);

        return nameList;
    }

    public int toInt(String inputAttempts) {
        validateNull(inputAttempts);

        int attempts = convertToInt(inputAttempts);
        return attempts;
    }

    private void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_NOT_ALLOWED);
        }
    }

    private List<String> convertToNameList(String names) {
        String[] nameArray = splitNames(names);

        List<String> nameList = Arrays.stream(nameArray)
                .map(name -> name.trim())
                .toList();
        return nameList;
    }

    private String[] splitNames(String names) {
        return names.split(NAME_DELIMITER);
    }

    private void validateNameList(List<String> nameList) {
        nameList.forEach(name -> validateName(name));

        validateDuplicateName(nameList);
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(NULL_NOT_ALLOWED);
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    private void validateDuplicateName(List<String> nameList) {
        Set<String> uniqueNames = new HashSet<>(nameList);
        if (uniqueNames.size() != nameList.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_NOT_ALLOWED);
        }
    }

    private int convertToInt(String inputAttempts) {
        try {
            return Integer.parseInt(inputAttempts);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT);
        }
    }
}
