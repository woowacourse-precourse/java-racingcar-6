package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarsGenerator;
import racingcar.domain.Race;

public class Application {

    public static void main(String[] args) {
        String carNames = requestCarNames();
        List<Car> cars = CarsGenerator.generateCars(carNames);
        Race race = new Race(cars);
        int raceCount = requestRaceCount();

        while (raceCount > 0) {
            race.play();
            raceCount--;
            System.out.println();
        }
        race.printWinner();
        Console.close();
    }

    private static String requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static int requestRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
