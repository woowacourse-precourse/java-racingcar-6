package racingcar.impl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.UserInput;

public class UserInputImpl implements UserInput {
    @Override
    public String readUserInputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public String readUserInputAttemptNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
 }
