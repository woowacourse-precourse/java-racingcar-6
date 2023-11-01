package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class InputValue {

    public ArrayList<Car> getCarsName(){
        System.out.println(GameMessage.REQUEST_ENTER_CAR_NAME_MESSAGE);
        String carNames = Console.readLine();
        String[] carListTest = carNames.split(",");

        ArrayList<Car> carList = new ArrayList<>();
        if(checkCarsNameInput(carListTest)){
            for(String car : carListTest){
                carList.add(new Car(car));
            }
            return carList;
        }else
            throw new IllegalArgumentException();
    }


    public int getGameNumber(){
        System.out.println(GameMessage.REQUEST_ENTER_GAME_NUMBER_MESSAGE);
        String gameNumber = Console.readLine();
        if(checkGameNumberInput(gameNumber))
            return parseInt(gameNumber);
        else
            throw new IllegalArgumentException();
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
