package racingcar;

import java.util.ArrayList;

public class RacingGame {
    private final ArrayList<Car> carList;
    private int gameNumber;

    public RacingGame(){
        InputValue inputValue = new InputValue();
        carList = inputValue.getCarsName();
        gameNumber = inputValue.getGameNumber();
    }


    public void start(){
        while(gameNumber>0){
            for(Car car:carList){
                car.run();
            }
            gameNumber--;
        }
    }


}

