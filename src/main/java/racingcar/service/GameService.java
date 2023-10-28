package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class GameService {

    public static void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        List<String> carNameList = new ArrayList<>();

        for (String s : carNames.split(",")) {
            if (s.contains(" ") || s.length() > 5 || carNameList.contains(s)) {
                throw new IllegalArgumentException();
            }
            carNameList.add(s);
        }

        List<Car> carList = carNameList.stream().map(Car::new).toList();
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int tryNum = Integer.parseInt(Console.readLine());

            if (tryNum <= 0) {
                throw new IllegalArgumentException();
            }

            System.out.println("실행 결과");
            RacingService.racing(carList, tryNum);
            RacingService.findWinner(carList);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
