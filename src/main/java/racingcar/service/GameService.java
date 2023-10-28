package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class GameService {

    public static void run() {
        List<Car> carList = new ArrayList<>();

        checkCarNameAndMakeCar(InteractService.getCarName(), carList);

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

    private static void checkCarNameAndMakeCar(String carNames, List<Car> carList) {
        List<String> carNameList = new ArrayList<>();

        for (String s : carNames.split(",")) {
            if (checkNameValidation(carNameList, s)) {
                throw new IllegalArgumentException();
            }
            carNameList.add(s);
            carList.add(new Car(s));
        }
    }

    private static boolean checkNameValidation(List<String> carNameList, String s) {
        return s.contains(" ") || s.length() > 5 || carNameList.contains(s);
    }
}
