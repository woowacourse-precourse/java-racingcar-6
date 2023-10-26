package racingcar.impl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.UserInput;
import racingcar.exception.InputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInputImpl implements UserInput {
    @Override
    public List<String> inputUserNames() {
        String userInput = Console.readLine();
        return parseName(userInput);
    }

    private List<String> parseName(String userInput) {
        String[] cutIntoComma = userInput.split(",");
        List<String> nameList = new ArrayList<>(Arrays.asList(cutIntoComma));
        try {

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return nameList;
    }

    @Override
    public int inputAttemptNum() {
        int inputAttemptNum;
        try {
            inputAttemptNum = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return 0;
    }
}
