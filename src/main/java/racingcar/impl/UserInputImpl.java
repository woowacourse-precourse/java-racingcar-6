package racingcar.impl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.UserInput;
import racingcar.entity.GameInfo;
import racingcar.exception.InputException;
import racingcar.util.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInputImpl implements UserInput {
    @Override
    public String getUserInputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public int getUserInputAttemptNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String attemptNum = Console.readLine();
        try {
            InputException.isValidAttemptNum(attemptNum);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(attemptNum);
    }


 }
