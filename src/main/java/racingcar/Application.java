package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        RacingManager racingManager = new RacingManager();
        List<RacingCar> racingCars = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = readLine();
        List<String> cars = racingManager.splitCarName(carName);
        for (String car : cars) {
            RacingCar racingCar = new RacingCar(car);
            racingCars.add(racingCar);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        racingManager.setLap(Integer.parseInt(readLine()));

        System.out.println("실행 결과");
        racingManager.race(racingCars);

        System.out.print("최종 우승자 : ");
        System.out.println(racingManager.finalWinner(racingCars));

    }
}
