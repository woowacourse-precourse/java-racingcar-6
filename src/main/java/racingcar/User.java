package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.StringUtil;

public class User {
    private String carNames;
    private int tryNum;

    public void readCarInput(){
        carNames = readCarsFromConsole();
    }

    public void readTryNumInput(){
        tryNum = Integer.parseInt(readTryNumFromConsole());
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTryNum() {
        return tryNum;
    }

    protected String readCarsFromConsole(){
        return Console.readLine();
    }

    protected String readTryNumFromConsole(){
        String tryNum = Console.readLine();
        if (isIllegalArgTryNum(tryNum)) {
            throw new IllegalArgumentException("시도횟수는 숫자여야 합니다.");
        }
        return tryNum;
    }

    private boolean isIllegalArgTryNum(String tryNum){
        return StringUtil.isDigit(tryNum);
    }
}
