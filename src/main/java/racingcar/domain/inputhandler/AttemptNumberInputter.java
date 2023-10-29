package racingcar.domain.inputhandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class AttemptNumberInputter {

    public int getAttemptNumber() {
        printInputMessage();
        int attempNumber = transformAttemptNumberToInt(readLine());
        return attempNumber;
    }

    private void printInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public boolean isValidNumber(String attemptNumber) {
        try {
            Integer.parseInt(attemptNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Integer transformAttemptNumberToInt(String attemptNumber) {
        if (isValidNumber(attemptNumber)) {
            return Integer.parseInt(attemptNumber);
        }
        throw new IllegalArgumentException("잘못된 인수를 입력하였습니다. " + attemptNumber);
    }
}
