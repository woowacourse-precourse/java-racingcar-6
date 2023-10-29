package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT = "시도할 회수는 몇회인가요?";

    public void inputCarName(){
        System.out.println(CAR_INPUT);
        String carName = Console.readLine();

        //유효성 검증
    }

    public void inputCount(){
        System.out.println(COUNT_INPUT);
        String count = Console.readLine();

        //유효성 검증
    }
}
