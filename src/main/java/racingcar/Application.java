package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        processInputValues();
    }

    private static void processInputValues() {
            System.out.print("자동차 이름 입력: ");
            String values = Console.readLine();

            // 쉼표로 분리
            String[] carNames = values.split(",");

            // 예외 처리: 값의 길이가 5 이상인 경우
            checkCarNameLength(carNames);
    }

    private static void checkCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.trim().length() >= 5) {
                throw new IllegalArgumentException("값의 길이가 5자 이상입니다.");
            }
        }
    }
}
