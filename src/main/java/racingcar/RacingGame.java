package racingcar;

import java.util.ArrayList;

public class RacingGame {
    private final ArrayList<Car> carList;
    private ArrayList<String> winnerList = new ArrayList<>();
    private int gameNumber;

    public RacingGame(){
        InputValue inputValue = new InputValue();
        carList = inputValue.getCarsName();
        gameNumber = inputValue.getGameNumber();
    }


    public void start(){
        System.out.println(GameMessage.RESULT_MESSAGE);
        while(gameNumber>0){
            for(Car car:carList){
                car.run();
                car.printState();
            }
            System.out.println();
            gameNumber--;
        }
    }

    public void getWinner(){
        int maxDistance = 0;
        for (Car car: carList) {
            if (car.getDistance()>maxDistance) {
                winnerList.add(car.getCarName());
                maxDistance=car.getDistance();
            }
        }
    }


}

