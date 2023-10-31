package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> carList;

    public Racing(List<String> nameList) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < nameList.size(); i++) {
            Car car = new Car(nameList.get(i), 0);
            carList.add(car);
        }

        this.carList = carList;
    }

    public String startRacing(List<String> nameList, int round) {
        StringBuilder racingResult = new StringBuilder();

        for (int i = 0; i < round; i++) {
            List<Integer> roundResult = new ArrayList<>();
            for (Car car : carList) {
                move(car);
                roundResult.add(car.move);
            }
            racingResult.append(result(nameList, roundResult));
        }
        return racingResult.toString();
    }

    private String result(List<String> nameList, List<Integer> roundResult) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        for (int i = 0; i < roundResult.size(); i++) {
            String name = nameList.get(i);
            String dash = "-".repeat(roundResult.get(i));

            sb.append(String.format("%s : %s%n", name, dash));
        }

        return sb.toString();
    }

    private void move(Car car) {
        if (isGo()) {
            car.move += 1;
        }
    }

    private Boolean isGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public List<String> determineWinner() {
        int maxMove = getMax();
        List<String> winner = new ArrayList<>();

        for (Car car : carList) {
            if (car.move == maxMove) {
                winner.add(car.name);
            }
        }

        return winner;
    }

    private int getMax() {
        int max = Integer.MIN_VALUE;
        for (Car car : carList) {
            if (car.move > max) {
                max = car.move;
            }
        }
        return max;
    }
}

