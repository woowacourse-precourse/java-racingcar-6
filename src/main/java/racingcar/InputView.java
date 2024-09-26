package racingcar;

import camp.nextstep.edu.missionutils.Console;

//입력 (InputView 클래스) : 사용자의 입력을 받는 기능

public class InputView {

    public static String[] getCarNames() {
        System.out.println("자동차 이름을 입력하세요(이름은 쉼표(,)로 구분, 5자 이하): ");
        return Console.readLine().split(",");
    }

    public static int getNumberOfMoves() {
        System.out.println("몇 번의 이동을 할 것인지 입력하세요: ");
        try {
            int moves = Integer.parseInt(Console.readLine());
            if (moves < 0) {
                throw new IllegalArgumentException("이동 횟수는 0 이상이어야 합니다.");
            }
            return moves;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 값을 입력해주세요.");
        }
    }
}

