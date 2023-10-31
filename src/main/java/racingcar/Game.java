package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> cars;
    private Integer totalMove;

    public void run() {

        cars = getCars();
        totalMove = getTotalMove();
    }

    private List<Car> getCars() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<Car> cars = new ArrayList<>();

        for (String carName : readLine().split(",")) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private Integer getTotalMove() {

        System.out.println("시도할 회수는 몇회인가요?");

        return Integer.parseInt(readLine());
    }
}
