package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String[] getCarNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return Console.readLine().split(",");
    }

    public static int getNumberOfMovesFromUser() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
