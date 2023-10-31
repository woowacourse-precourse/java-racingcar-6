package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validation;

public class InputView {
    private final Validation validation = new Validation();
    public String[] startGame(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }
    public Integer inputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        Integer tryCount = Integer.valueOf(Console.readLine());

        return validation.validTryCount(tryCount);
    }
}
