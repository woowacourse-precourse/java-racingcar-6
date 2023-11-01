package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 입출력을 담당하는 클래스
 *
 * @author gemstoneyang
 */
public class DataIOHandler {

    /**
     * 사용자의 이름 입력을 받고 검증하는 메소드
     *
     * @return 사용자의 이름 입력값
     */
    public static String getNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        Validator.validateNameInput(input);

        return input;
    }

    /**
     * 사용자의 시도 입력을 받고 검증하는 메소드
     *
     * @return 사용자의 시도 입력값
     */
    public static Integer getTryCountInput() {
        System.out.println("시도할 회수는 몇회인가요?");

        String input = Console.readLine();
        Validator.validateTryCountInput(input);

        return Integer.parseInt(input);
    }
}
