package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String CarNames = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String tryGame = "시도할 회수는 몇회인가요?";

    public String readCarNames(){
        System.out.println(CarNames);
        return Console.readLine();
    }

    public int readTryGame() {
        System.out.println(tryGame);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }
}
