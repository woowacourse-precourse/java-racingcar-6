package racingcar;

import racingcar.domain.Attempt;
import racingcar.domain.CarsFactory;
import racingcar.domain.Game;

/**
 * 객체 지향 프로그래밍 1. 기능을 가지고 있는 클래스를 인스턴스화(=객체)한다. 2. 필요한 기능을 (역할에 맞는) 인스턴스가 수행하게 한다. (의인화) 3. 각 결과를 종합한다.
 */
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarsFactory carsFactory = new CarsFactory();
        carsFactory.startCreateCars();

        Attempt attempt = new Attempt();
        attempt.saveAttemptNumber();

        Game game = new Game(carsFactory.getCars(), attempt.getCount());
        game.startRacing();
    }
}
