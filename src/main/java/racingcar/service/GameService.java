package racingcar.service;


import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GamePlayer;

/*
 *   racingCar게임의 기능들을 담당
 * */

public class GameService {


    public GamePlayer settingPlayer(List<String> carNames) {
        GamePlayer gamePlayer = new GamePlayer();
        addCarsToGamePlayer(gamePlayer, initializeCars(carNames));
        return gamePlayer;
    }

    private void addCarsToGamePlayer(GamePlayer gamePlayer, List<Car> cars) {
        for (Car car : cars) {
            gamePlayer.addCar(car);
        }
    }

    private List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }


}
