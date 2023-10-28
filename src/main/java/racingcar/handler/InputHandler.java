package racingcar.handler;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constants.ExceptionMessageConstants.*;

public class InputHandler {

    public List<String> convertNamesToNameList(String names) {
        if (names == null || names.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_NOT_ALLOWED);
        }

        String[] nameArray = names.split(",");
        List<String> nameList = new ArrayList<>();

        for (String name : nameArray) {
            String trimName = name.trim();

            validName(trimName, nameList);

            nameList.add(trimName);
        }

        return nameList;
    }

    public int convertAttemptsToInt(String inputAttempts) {
        if (inputAttempts == null || inputAttempts.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_NOT_ALLOWED);
        }

        try {
            return Integer.parseInt(inputAttempts);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT);
        }
    }

    private void validName(String trimName, List<String> nameList) {
        if (trimName.isEmpty()) {
            throw new IllegalArgumentException(NULL_NOT_ALLOWED);
        }
        if (nameList.contains(trimName)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_NOT_ALLOWED);
        }
        if (trimName.length() >= 5) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }
}
