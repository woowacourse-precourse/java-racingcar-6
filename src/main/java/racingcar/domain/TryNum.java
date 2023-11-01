package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.Util.Verification.verifyTryNum;

public class TryNum {
    public static int getTryNum() {
        String inputTryNum = Console.readLine();

        verifyTryNum(inputTryNum);

        return Integer.parseInt(inputTryNum);
    }
}