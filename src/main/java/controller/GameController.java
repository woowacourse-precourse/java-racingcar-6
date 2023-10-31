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

}
