package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class TryNumberScanService {
    private String stringTryNumber = null;

    public void readTryNumber() {
        stringTryNumber = Console.readLine();
    }

    public String getStringTryNumber() {
        return stringTryNumber;
    }
}
