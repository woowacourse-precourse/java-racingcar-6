package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private static RacingCarGame racingCarGame;

    private RacingCarGame() {
    }

    public static RacingCarGame getInstance() {
        if (racingCarGame == null) {
            racingCarGame = new RacingCarGame();
        }
        return racingCarGame;
    }

    public void run() {
        String carsName = getCarsName();
        String[] carName = extractCarName(carsName);
        List<Car> carList = generateCars(carName);
    }

    private String getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsName = Console.readLine();
        return carsName;
    }

    private String[] extractCarName(String carsName) {
        String[] carName = carsName.split(",");
        return carName;
    }

    private List<Car> generateCars(String[] carName) {
        List<Car> carList = new ArrayList<>();
        int repeatNumber = carName.length;
        int nameOrder = 0;
        while (repeatNumber != 0) {
            carList.add(new Car(carName[nameOrder]));
            repeatNumber--;
            nameOrder++;
        }
        return carList;
    }
}
