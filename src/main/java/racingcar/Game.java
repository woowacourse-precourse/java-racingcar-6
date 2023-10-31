package racingcar;

import java.util.Map;

public class Game {
    public void opening() {
        Input input = new Input();
        String[] car_name = input.carName();
        Map<String, Integer> parkinglot = input.carDistance(car_name);
        int runtime = input.runtime();
        System.out.println();
        gameStart(parkinglot, car_name, runtime);
    }
    public void gameStart(Map<String,Integer> parkinglot, String[] car_name, int runtime) {
        System.out.println("실행 결과");
        for (int i = 0; i < runtime; i++) {

        }
    }

}