package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String INPUT_ATTEMPTS = "시도할 회수는 몇회인가요?";

    public static String carsName(){
        System.out.println(INPUT_CARS_NAME);
        return Console.readLine();
    }

    public static String attempts(){
        System.out.println(INPUT_ATTEMPTS);
        return Console.readLine();
    }
}
