package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.StringUtil;

public class User {
    private String carNames;
    private int tryNum;

    public void readCarInput() {
        carNames = readCarsFromConsole();
    }

    public void readTryNumInput() {
        tryNum = readTryNumFromConsole();
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTryNum() {
        return tryNum;
    }

    protected String readCarsFromConsole() {
        return Console.readLine();
    }

    protected int readTryNumFromConsole() {
        return verify(Console.readLine());
    }

    protected int verify(String tryNumInput) {
        try {
            return Integer.parseInt(tryNumInput);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("시도횟수는 숫자여야 합니다.");
        }
    }
}
