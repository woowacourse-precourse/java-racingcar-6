package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * packageName    : view
 * fileName       : InputView
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-26        qkrtn_ulqpbq2       최초 생성
 */
public class InputView {

    public static String carNames = "";
    public static final String DELIMITER = ",";

    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_TRY_CNT = "시도할 회수는 몇회인가요?";
    public static String inputCarNames() {
        boolean validInput;

        do {
            System.out.println(INPUT_CAR_NAMES);
            carNames = Console.readLine();
            validInput = isValidCarNames(carNames);
        } while (!validInput);

        return carNames;
    }

    private static boolean isValidCarNames(String carNames) {
        if (!carNames.contains(DELIMITER)) {
            return false;
        }
        return true;
    }

    public static String inputTryCount() {
        System.out.println(INPUT_TRY_CNT);
        return Console.readLine();
    }
}
