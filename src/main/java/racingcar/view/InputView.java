package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String CarNames = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String tryGame = "시도할 회수는 몇회인가요?";

    public static String readCarNames(){
        System.out.println(CarNames);
        return Console.readLine();
    }

    public static int readTryGame(){
        System.out.println(tryGame);
        return Integer.parseInt(Console.readLine());
    }
}
