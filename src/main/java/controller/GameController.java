package controller;

import model.Car;

import camp.nextstep.edu.missionutils.Randoms;
import model.CarList;

public class GameController {
    private final UserController userController;
    private final CarList carList;

    public GameController(UserController userController, CarList carList) {
        this.userController = userController;
        this.carList = carList;
    }

    public void run() {
        userController.getUserValue();
        playGame();
    }

    void playGame() {
        for (int i = 0; i < userController.getCoin(); i++) {
            playRound();
        }

        printWinner();
    }

    public void playRound() {
        for (int i = 0; i < carList.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            progressCar(carList.get(i), randomNumber);
        }

        carList.printCarsState();
    }

    void progressCar(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.moveForward();
        }
    }

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

    void printWinner() {
        String winnerName = calculateWinner();
        System.out.println("최종 우승자 : " + winnerName);
    }
}
