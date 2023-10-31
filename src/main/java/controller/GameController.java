package controller;

import dto.Car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class GameController {
    private final UserController userController;
    private final ArrayList<Car> racingCars;
    private final int coin;
    public GameController(UserController userController){
        this.userController = userController;
        this.coin = userController.getCoin();
        this.racingCars = userController.getRacingCars();
    }

    public void run(){
        userController.intputUserValue();
        playGame();
        printWinner();
    }
    void playGame(){
        for(int i=0; i<coin; i++){
            playRound();
        }
    }

    void playRound(){
        for(int j=0; j<racingCars.size(); j++){
            Car car = racingCars.get(j);
            int randomNumber = Randoms.pickNumberInRange(0,9);

            progressCar(car, randomNumber);
        }
    }

    void progressCar(Car car, int randomNumber){
        if(randomNumber >= 4){
            int currentDistance = car.getDistance();
            car.setDistance(currentDistance+1);
        }
    }

    String calculateWinner(){
        Car winner = racingCars.get(0);
        String winnerName = winner.getName();

        for(int i=1; i<racingCars.size(); i++){
            Car candidate = racingCars.get(i);
            if(winner.getDistance() < candidate.getDistance()){
                winner = candidate;
                winnerName = candidate.getName();
            } else if (winner.getDistance() == candidate.getDistance()) {
                winnerName.concat(", " + candidate.getName());
            }
        }
        return winnerName;
    }

    void printWinner(){
        String winnerName = calculateWinner();
        System.out.println(winnerName + '\n');
    }
}
