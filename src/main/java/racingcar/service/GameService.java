package racingcar.service;


import racingcar.domain.GamePlayer;
import racingcar.domain.GameRank;
import racingcar.domain.GameWinner;
import racingcar.dto.CarNames;
import racingcar.dto.MoveCount;
import racingcar.view.OutputView;

/*
 *   racingCar게임의 기능들을 담당
 * */

public class GameService {

    //    public GamePlayer createGamePlayer(List<String> carNames) {
//        GamePlayer gamePlayer = new GamePlayer();
////        GamePlayer gamePlayer = GamePlayer.create(initializeCars());
//        addCarsToGamePlayer(gamePlayer, initializeCars(carNames));
//        return gamePlayer;
//    }
//
//    private void addCarsToGamePlayer(GamePlayer gamePlayer, List<Car> cars) {
//        for (Car car : cars) {
//            gamePlayer.addCar(car);
//        }
//    }
//
//    private List<Car> initializeCars(List<String> carNames) {
//        List<Car> cars = new ArrayList<>();
//        for (String carName : carNames) {
//            cars.add(new Car(carName));
//        }
//        return cars;
//    }
    public GamePlayer createGamePlayer(CarNames carNames) {
        return GamePlayer.from(carNames);
    }

    public void moveCarsByCount(GamePlayer gamePlayer, MoveCount moveCount) {
        //OutputView.beforeMoveMessage() 로 하는 것이 더 가독성이 좋은가
        OutputView.beforeMove();
        for (int i = 0; i < moveCount.getMoveCount(); i++) {
            gamePlayer.moveCars();
        }
    }


    public GameRank createGameRank(GamePlayer gamePlayer) {
        return gamePlayer.createGameRank();
    }


    public GameWinner createGameWinner(GameRank gameRank) {
        return gameRank.createGameWinner();
    }

}
