package game;

import camp.nextstep.edu.missionutils.Randoms;
import car.Car;
import util.GamePrinter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameReferee {


    private static final int MID_NUMBER = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private RandomGenerator randomGenerator;

    public GameReferee(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public void allMove(List<Car> carList) {

        for (Car car : carList) {
            if (isMove()) {
                car.move();
            }
            GamePrinter.printCarNamePosition(car);
        }
    }

    private boolean isMove() {
        int random = randomGenerator.pickNumberInRange(MIN_NUMBER,MAX_NUMBER);

        if (random < MID_NUMBER) {
            return false;
        }

        return true;
    }

    public void determineWinner(List<Car> carList) {

        List<String> winnerCarNames = new ArrayList<>();

        int maxPosition = carList.stream().max(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getPosition() - o2.getPosition();
            }
        }).get().getPosition();

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winnerCarNames.add(car.getName());
            }
        }


        GamePrinter.determineWinner(winnerCarNames);
    }
}
