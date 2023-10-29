package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameModel {
    private List<Car> cars;
    private Queue<List<Car>> roundSnapShots;

    public void setCars(final List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.cars = cars;
        this.roundSnapShots = new LinkedList<>();
    }

    public Queue<List<Integer>> getMoveNumbers(final int roundNumber) {
        Queue<List<Integer>> moveNumbers = new LinkedList<>();
        for (int i = 0; i < roundNumber; i++) {
            List<Integer> roundMoveNumbers = getCarMoveNumbers();
            moveNumbers.add(roundMoveNumbers);
        }
        return moveNumbers;
    }

    public void playGame(final Queue<List<Integer>> moveNumbers) {
        while (!moveNumbers.isEmpty()) {
            List<Integer> carMoveNumbers = moveNumbers.poll();
            playRound(carMoveNumbers);
            roundSnapShots.add(cars);
        }
    }

    private void playRound(final List<Integer> carMoveNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            int moveNumber = carMoveNumbers.get(i);
            if (isMove(moveNumber)) cars.get(i).move();
        }
    }

    private List<Integer> getCarMoveNumbers() {
        List<Integer> moveNumbers = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            int number = Randoms.pickNumberInRange(0, 9);
            moveNumbers.add(number);
        }
        return moveNumbers;
    }

    private boolean isMove(final int moveNumber) {
        return moveNumber >= 4;
    }

    public List<Car> getCars() {
        return cars;
    }

    }
}
