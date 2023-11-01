package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    public RacingGame() {
        Progress();
    }

    private void Progress() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] names = InputName();

        System.out.println("시도할 회수는 몇회인가요?");
        int num = InputNumber();

        System.out.println("\n실행 결과");
    }

    private String[] InputName() {
        String[] names = Console.readLine().split(",");
        //검사-자동차 수가 2개보다 작으면 예외처리
        if (names.length <= 1) {
            throw new IllegalArgumentException();
        }
        return names;
    }

    private int InputNumber() {
        int num;
        try {
            //검사
            num = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException();
        }
        return num;
    }
}
