package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class InputValidation {
    private static final String INPUT_DELIMITER = ",";

    public static String[] validateInputNames(String userInput) throws IllegalArgumentException {
        String[] participantsNameList = userInput.split(INPUT_DELIMITER);
        HashSet<String> checkDuplicate = new HashSet<>(participantsNameList.length);

        for (String participantName : participantsNameList) {
            if (participantName.length() >= 6) {
                throw new IllegalArgumentException(participantName + " is too long!");
            }
            if (checkDuplicate.contains(participantName)) {
                throw new IllegalArgumentException(participantName + " already exists");
            }
            checkDuplicate.add(participantName);
        }

        return participantsNameList;
    }

    public static String[] askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawCarNames = Console.readLine();
        return InputValidation.validateInputNames(rawCarNames);
    }

    public static int validateInputMoveCount(String userInput) throws IllegalArgumentException {
        int moveCount;
        try {
            moveCount = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(userInput + " is not an integer");
        }

        if (moveCount < 0) {
            throw new IllegalArgumentException(userInput + " is negative");
        }

        return moveCount;
    }

    public static int askTotalMoveCounts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String rawMoveCount = Console.readLine();
        return InputValidation.validateInputMoveCount(rawMoveCount);
    }
}
