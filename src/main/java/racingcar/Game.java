package racingcar;

import java.util.Map;

public class Game {
    public void opening() {
        Input ip = new Input();
        String[] car_name = ip.carName();
        Map<String, Integer> parkinglot = ip.carDistance(car_name);
        int runtime = ip.runtime();
        System.out.println();
        gameStart(parkinglot, car_name, runtime);
    }
    public void gameStart(Map<String,Integer> parkinglot, String[] car_name, int runtime) {

    }
}
