package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private void inputCarName(){
        System.out.println(CAR_INPUT);
        String carName = Console.readLine();

        //유효성 검증
    }
}
