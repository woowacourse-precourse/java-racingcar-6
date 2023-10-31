package racingcar.service;


import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarNames;
import racingcar.domain.GamePlayer;
import racingcar.domain.GameWinner;

/*
 *   racingCar게임의 기능들을 담당
 * */

public class GameService {

    public GamePlayer createGamePlayer(CarNames carNames) {
        return GamePlayer.from(carNames);
    }

    public GameWinner createGameWinner(GamePlayer gamePlayer) {
        List<Car> cars = gamePlayer.getCars();
        int maxMoveDistance = gamePlayer.getMaxMoveDistance();
        List<Car> winningCars = cars.stream()
                .filter(car -> car.getMoveDistance() == maxMoveDistance)
                .toList();
        return GameWinner.from(winningCars);
    }


    public void moveCars(GamePlayer gamePlayer) {
        //OutputView.beforeMoveMessage() 로 하는 것이 더 가독성이 좋은가
        gamePlayer.moveCars();
    }
}
