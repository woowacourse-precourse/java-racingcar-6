package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String REGULAR_EXP_CAR_NAMES = "^[a-zA-Z0-9가-힣]+(,[a-zA-Z0-9가-힣]+)*";
    private static final String SEPARATOR = ",";

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = readLine();

        if (!carNames.matches(REGULAR_EXP_CAR_NAMES)) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 올바르지 않습니다.");
        }

        return carNames.split(SEPARATOR);
    }

    public static int getAttemptCount() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자만 입력할 수 있습니다.");
        }
    }

}
