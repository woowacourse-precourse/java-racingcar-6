package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class RacingGame {
    private ArrayList<Car> carList = new ArrayList<>();
    private int gameNumber;

    public void getCarsName(){
        System.out.println(GameMessage.REQUEST_ENTER_CAR_NAME_MESSAGE);
        String carNames = Console.readLine();
        String[] carListTest = carNames.split(",");
        if(checkCarsNameInput(carListTest)){
            for(String car : carListTest){
                carList.add(new Car(car));
            }
        }else
            throw new IllegalArgumentException();
    }


    public void getGameNumber(){
        System.out.println(GameMessage.REQUEST_ENTER_GAME_NUMBER);
        String gameNumber = Console.readLine();
        if(checkGameNumberInput(gameNumber))
            this.gameNumber = parseInt(gameNumber);
    }


    private Boolean checkCarsNameInput(String[] carListTest){
        if(carListTest.length<1)
            return false;
        for(String car:carListTest){
            if(car.length()>5)
                return false;
        }
        return true;
    }

    private Boolean checkGameNumberInput(String num) {
        return num.matches("-?\\d+(\\.\\d+)?") && !num.equals("0");
    }

}

