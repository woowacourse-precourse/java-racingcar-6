package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        List<String> names = Arrays.stream(Console.readLine().split(",")) // ","로 split
                .map(name -> name.replaceFirst("\\s+", "")) // 문자열 맨 앞의 공백을 모두 제거
                .toList();

        Optional<String> any = names.stream().filter(name -> name.length() > 5 || name.length() == 0).findAny();
        if (any.isPresent()) {
            throw new IllegalArgumentException();
        }

        return names;
    }

    public int readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int i = Integer.parseInt(Console.readLine());
            if (i <= 0) {
                throw new IllegalArgumentException();
            }
            return i;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
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
