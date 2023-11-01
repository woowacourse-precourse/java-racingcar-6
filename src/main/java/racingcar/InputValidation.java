package racingcar;

import java.util.HashSet;

public class InputValidation {
    private static final String INPUT_DELIMITER = ",";

    public static String[] validateInputNames(String userInput) throws IllegalArgumentException {
        String[] participantsNameList = userInput.split(INPUT_DELIMITER);
        HashSet<String> checkDuplicate = new HashSet<>(participantsNameList.length);

        for (String participantName : participantsNameList) {
            if (participantName.length() >= 6)
                throw new IllegalArgumentException(participantName + " is too long!");
            if (checkDuplicate.contains(participantName))
                throw  new IllegalArgumentException(participantName + " already exists");
            checkDuplicate.add(participantName);
        }

        return participantsNameList;
    }

    public static int validateInputMoveCount(String userInput) throws IllegalArgumentException {
        int moveCount;
        try {
            moveCount = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(userInput + " is not an integer");
        }

        if (moveCount < 0)
            throw  new IllegalArgumentException(userInput + " is negative");

        return moveCount;
    }
}
