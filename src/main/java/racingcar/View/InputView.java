package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String racingCarName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String tryCount = "시도할 횟수는 몇회인가요?";

    public String AskCarName(){
        System.out.println(racingCarName);
        return Console.readLine();
    }

    public String AskTryCount(){
        System.out.println(tryCount);
        return Console.readLine();
    }
}
