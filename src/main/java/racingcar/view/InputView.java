package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        return Console.readLine();
    }

    public String getTrial() {
        System.out.print("시도할 회수는 몇회인가요?\n");
        return Console.readLine();
    }
}
