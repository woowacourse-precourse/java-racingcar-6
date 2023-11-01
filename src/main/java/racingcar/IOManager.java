package racingcar;

import camp.nextstep.edu.missionutils.*;
import racingcar.car.Cars;

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

    public void printRacingResult(Cars cars) {
        cars.Results().forEach(System.out::println);
        System.out.println();
    }

    public void notifyStartRacing() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printWinners(Cars cars) {
        List<String> winners = cars.winners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
