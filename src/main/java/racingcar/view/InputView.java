package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACING_COUNT_NAME = "시도할 회수는 몇회인가요?";

    public String inputCarsName(){
        System.out.println(INPUT_CARS_NAME);
        String s = Console.readLine();
        Console.close();
        return s;
    }

    public String inputRacingCount(){
        System.out.println(INPUT_RACING_COUNT_NAME);
        String s=Console.readLine();
        Console.close();
        return s;
    }

}
