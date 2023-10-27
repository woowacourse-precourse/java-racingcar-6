package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class TryNumberScanService {
    public static int tryNumber = 0;

    public void readTryNumber() {
        tryNumber = stringToInt(Console.readLine());
    }

    public int stringToInt(String stringTryNumber) {
        return Integer.parseInt(stringTryNumber);
    }
}
