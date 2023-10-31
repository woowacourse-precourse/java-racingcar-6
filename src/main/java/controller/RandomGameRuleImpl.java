package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Car;
import model.CarList;

public class RandomGameRuleImpl implements GameRule {
    private final CarList carList;

    public RandomGameRuleImpl(CarList carList) {
        this.carList = carList;
    }

    @Override
    public void playRound() {
        for (int i = 0; i < carList.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            progressCar(carList.get(i), randomNumber);
        }

        carList.printCarsState();
    }

    @Override
    public void progressCar(Car car, int randomNumber) {
        if (randomNumber >= 4) {
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
                winnerName += (", " + candidate.getName());
            }
        }
        return winnerName;
    }
}
