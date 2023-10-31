package racingcar;

import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carNames = CarNamesInput.namesInput();
        Integer round = RoundNumberInput.roundNumInput();
        List<Car> cars = Cars.buildCar(carNames);
        GameStarter.gameIniter(cars, round);






    }
}
