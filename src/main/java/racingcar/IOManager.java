package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.Arrays;
import java.util.List;

public class IOManager {

    private static IOManager ioManager;

    private IOManager() {
    }

    public static IOManager getInstance() {
        if (ioManager == null) {
            ioManager = new IOManager();
        }
        return ioManager;
    }

    public List<String> readCarNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(Console.readLine().split(",")).toList();
    }

    public int readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
