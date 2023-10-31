package controller;

import model.Car;

import camp.nextstep.edu.missionutils.Randoms;

public class GameController {
    private final UserController userController;

    public GameController(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        userController.intputUserValue();
        playGame();
    }

    void playGame() {
        for (int i = 0; i < userController.getCoin(); i++) {
            playRound();
        }

        printWinner();
    }

    public void playRound() {
        for (int i = 0; i < userController.getRacingCars().size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            progressCar(userController.getRacingCars().get(i), randomNumber);
        }

        printCarState();
    }

    void progressCar(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.moveForward();
        }
    }

    void printCarState() {
        for (int i = 0; i < userController.getRacingCars().size(); i++) {
            System.out.println(userController.getRacingCars().get(i).toString());
        }
        System.out.println();
    }

    public String calculateWinner() {
        Car winner = userController.getRacingCars().get(0);
        String winnerName = winner.getName();

        for (int i = 1; i < userController.getRacingCars().size(); i++) {
            Car candidate = userController.getRacingCars().get(i);

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
