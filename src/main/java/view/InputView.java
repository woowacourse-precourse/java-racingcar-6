package view;

import camp.nextstep.edu.missionutils.Console;

import static util.Messages.INPUT_CAR_NAMES;
import static util.Messages.INPUT_TRY_CNT;

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
    public static String inputCarNames(){
        System.out.print(INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public static String inputTryCount() {
        System.out.println(INPUT_TRY_CNT);
        return Console.readLine();
    }
}
