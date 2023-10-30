package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String carNameInputView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String memberInput = Console.readLine();
        return memberInput;
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryInput = Console.readLine();
        int tryCount = Integer.parseInt(tryInput);

        tryCountException(tryCount);

        return tryCount;
    }

    public static void tryCountException(int tryCount) {
        // * 시도 횟수 예외 처리
        // 입력 값이 숫자가 아닌 경우
        if (Character.isDigit(tryCount)) {
            throw new IllegalArgumentException();
        }

        // 입력 값이 0 이하인 경우
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
