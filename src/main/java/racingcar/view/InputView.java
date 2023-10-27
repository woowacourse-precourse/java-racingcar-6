package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_REPEAT = "시도할 회수는 몇회인가요?";

    private InputView() {
        // 생성자 호출 방지
    }

    public static String[] inputNames() {
        return inputNames(Console.readLine());
    }
    public static String[] inputNames(String input) {
        System.out.println(INPUT_NAME);
        return input.split(",");
    }

    public static int inputRepeat() {
        return inputRepeat(Console.readLine());
    }
    public static int inputRepeat(String input) {
        System.out.println(INPUT_REPEAT);
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[Error]: 잘못된 시도횟수 입력");
        }
    }
}
