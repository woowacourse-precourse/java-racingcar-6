package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
//    private List<String> CarNames = new ArrayList<>();

    private static void displayStartText() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    //    private static void inputCarNames() {
//
//    }
    private static int inputCarMovingCount() {
        return Integer.parseInt(Console.readLine());
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        displayStartText();
        inputCarMovingCount();
    }
}
