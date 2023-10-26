package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.controller.CarController;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Game;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        GameController gameController = new GameController();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = carController.makeCar(readLine());
        System.out.println("시도할 회수는 몇회인가요?");
        Game game = gameController.makeGame(readLine());
        System.out.println("\n실행 결과");
        gameController.judge(cars, game);
        gameController.score(cars);
        System.out.println("최종 우승자 : " + gameController.score(cars));
    }
}
