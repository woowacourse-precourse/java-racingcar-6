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

    public void gameStart(Map<String, Integer> parkinglot, String[] car_name, int runtime) {
        Output output = new Output();
        System.out.println("실행 결과");
        for (int i = 0; i < runtime; i++) {
            movingCar(parkinglot, car_name);
            output.totalPrint(parkinglot, car_name);
        }
        if (runtime == 0) {
            System.out.println();
        }
        System.out.println(output.winner(parkinglot, car_name));
    }

    public void movingCar(Map<String, Integer> parkinglot, String[] car_name) {
        Output output = new Output();
        for (int i = 0; i < car_name.length; i++) {
            int randomNumber = output.randomNumber();
            if (Check.checkForward(randomNumber)) {
                int car_distance = parkinglot.get(car_name[i]);
                parkinglot.put(car_name[i], car_distance + 1);
            }
        }
    }
}