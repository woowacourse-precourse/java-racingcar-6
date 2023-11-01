package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<String> carNames;
    int round;

    public Game() {
        carNames = Input.inputCarNames();
        round = Input.inputRound();
    }

    public void run() {
        System.out.println("실행 결과");

    }

    private List<Car> setCars() {
        List<Car> carEntry = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            carEntry.add(new Car(carNames.get(i)));
        }
        return carEntry;
    }

    private void raceStart(List<Car> carEntry) {
        for (int i = 0; i < round; i++) {
            for(int j = 0;j<carEntry.size();j++){
                carEntry.get(i).onceRoundStart();
                carEntry.get(i).printCarState();
            }
            System.out.println();
        }
    }

    private void checkWinners(){

    }
}
