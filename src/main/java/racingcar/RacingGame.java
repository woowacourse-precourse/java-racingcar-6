package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<Car> carList = new ArrayList<>();

    public void getCarsName(){
        System.out.println(GameMessage.REQUEST_ENTER_CAR_NAME_MESSAGE);
        String carNames = Console.readLine();
        String[] carListTest = carNames.split(",");
        if(checkCarsName(carListTest)){
            for(String car : carListTest){
                carList.add(new Car(car));
            }
        }else
            throw new IllegalArgumentException();
    }

    public Boolean checkCarsName(String[] carListTest){
        if(carListTest.length<1)
            return false;
        for(String car:carListTest){
            if(car.length()>5)
                return false;
        }
        return true;
    }

}

