package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Car;
import model.CarList;

public class RandomGameRuleImpl implements GameRule {
    static final String IDENTIFIER = ", ";
    static final int RANDOM_MIN = 0;
    static final int RANDOM_MAX = 9;
    static final int PROGRESS_VALUE = 4;

    private final CarList carList;

    public RandomGameRuleImpl(CarList carList) {
        this.carList = carList;
    }

    @Override
    public void playRound() {
        for (int i = 0; i < carList.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);

            progressCar(carList.get(i), randomNumber);
        }

        carList.printCarsState();
    }

    @Override
    public void progressCar(Car car, int randomNumber) {
        if (randomNumber >= PROGRESS_VALUE) {
            car.moveForward();
        }
    }

    @Override
    public String calculateWinner() {
        Car winner = carList.get(0);
        String winnerName = winner.getName();

        for (int i = 1; i < carList.size(); i++) {
            Car candidate = carList.get(i);

            if (winner.getDistance() < candidate.getDistance()) {
                winner = candidate;
                winnerName = candidate.getName();
            } else if (winner.getDistance() == candidate.getDistance()) {
                winnerName += (IDENTIFIER + candidate.getName());
            }
        }
        return winnerName;
    }
}
