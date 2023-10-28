package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = new Cars();

        GameView.gameStart();
        cars.createCar(Input.inputCarName());
        GameView.gameCount();
        cars.moveCount = Input.inputGameCount();

        GameView.gameMonitoring((HashMap<String, Integer>) cars.carMap,cars.moveCount);
        //차량생성까지 끝 게임 시작 ~

        for(int i=0;i < cars.moveCount;i++){
            cars.moveCar();
            GameView.gameCurrent((HashMap<String, Integer>) cars.carMap);
        }

        GameView.gameResult(cars.referee());
    }
}
