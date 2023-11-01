package racingcar;

import camp.nextstep.edu.missionutils.Console;

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
        return Console.readLine();
    }
}
