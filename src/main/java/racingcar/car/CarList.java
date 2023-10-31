package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.outputView.Output;

import static racingcar.util.FixedNumber.MAX_NUMBER;
import static racingcar.util.FixedNumber.MIN_NUMBER;
import static racingcar.util.FixedNumber.AVAILABLE_MOVE;


public class CarList {
    private static List<Car> carList = new ArrayList<>();

    public CarList(String[] cars) {
        for (String name : cars) {
            Car car = new Car(name);
            carList.add(car);
        }
    }

    public void printExecuteCarsMove() {
        carsMove();

        for (Car car : carList) {
            String detail = printName(car.carName()) + printCarPosition(car.carPosition());
            System.out.println(detail);
        }

        Output.lineBreaking();
    }

    public String printName(String name) {
        name += " : ";
        return name;
    }

    public String printCarPosition(int position) {
        String movePosition = "";

        for (int i = 0; i < position; i++) {
            movePosition = movePosition + "-";
        }

        return movePosition;
    }

    public String[] printWinnerList() {
        List<String> winnerList = new ArrayList<>();

        int winnerScore = highestScore();

        for (Car car : carList) {
            if (car.carPosition() == winnerScore) {
                winnerList.add(car.carName());
            }
        }

        return winnerList.toArray(new String[winnerList.size()]);
    }

    public int highestScore() {
        int maxScore = 0;

        for (Car car : carList) {
            if (maxScore < car.carPosition()) {
                maxScore = car.carPosition();
            }
        }

        return maxScore;
    }

    public void carsMove() {
        for (Car car : carList) {
            if (Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) >= AVAILABLE_MOVE) {
                car.moveCar();
            }
        }
    }
}
