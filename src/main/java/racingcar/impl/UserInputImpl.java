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
        return Console.readLine();
    }

    @Override
    public int getUserInputAttemptNum() {
        String attemptNum = Console.readLine();
        try {
            InputException.isValidAttemptNum(attemptNum);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(attemptNum);
    }


 }
