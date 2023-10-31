package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public static int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static void printFinalWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
