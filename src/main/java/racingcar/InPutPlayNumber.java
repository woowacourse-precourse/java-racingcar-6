package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InPutPlayNumber {

    private static final int BOUNDARY_VALUE = 0;
    private static final String ERROR_BOUNDARY_MESSAGE = "[ERROR] 양수를 입력하세요.";
    private static final String TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    public static int inPutNumber(){
        System.out.println(TRY_NUMBER_MESSAGE);
        int tryNumber = Integer.parseInt(Console.readLine());

        return tryNumber;
    }

    public static void playNumberValidator(int tryNumber) {
        if (tryNumber < BOUNDARY_VALUE) {
            throw new IllegalArgumentException(ERROR_BOUNDARY_MESSAGE);
        }
    }
}

