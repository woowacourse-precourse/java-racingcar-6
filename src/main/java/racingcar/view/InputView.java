package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        validateCarNames(carNames);
        return carNames;
    }

    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 " + MAX_CAR_NAME_LENGTH + "자 이하로 입력해주세요.");
            }
        }
    }

    public static int getAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());
        validateAttemptCount(attemptCount);
        return attemptCount;
    }

    public static void validateAttemptCount(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("시도할 회수는 양의 정수로 입력해주세요.");
        }
    }
}

