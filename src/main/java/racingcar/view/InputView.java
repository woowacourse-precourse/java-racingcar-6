package racingcar.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {

    private static String input = Console.readLine();

    public static final int MAX_NAME_LENGTH = 5;

    public static final String COMMA = ",";

    public String startGame(){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return input;
    }

    public int startGameCount(){

        System.out.println("시도할 회수는 몇회인가요?");

        return Integer.parseInt(input);

    }
}
