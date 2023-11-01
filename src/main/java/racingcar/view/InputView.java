package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 입력 관리
 *
 * @see camp.nextstep.edu.missionutils.Console
 */
public class InputView {
    /**
     * 경주 할 자동차 이름 입력
     *
     * @return String 입력한 자동차 이름
     */
    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    /**
     * 시도할 횟수 입력
     *
     * @return String 입력한 시도할 횟수
     */
    public static String getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
