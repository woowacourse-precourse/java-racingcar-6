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
        printResult();
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


    public void printResult(){
        System.out.print(GameMessage.WINNER_MESSAGE);
        getWinner();

        while(!winnerList.isEmpty()){
            System.out.print(winnerList.remove(0));
            if(winnerList.size()>1)
                System.out.print(", ");
        }
    }


}

