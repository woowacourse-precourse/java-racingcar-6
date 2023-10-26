package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_REPEAT = "시도할 회수는 몇회인가요?";

    private InputView() {
        // 생성자 호출 방지
    }

    public static String[] inputNames() {
        System.out.println(INPUT_NAME);
        return Console.readLine().split(",");
    }

    public static int inputRepeat() {
        System.out.println(INPUT_REPEAT);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[Error]: 잘못된 시도횟수 입력");
        }
    }
}
