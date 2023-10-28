package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<Car> carList = new ArrayList<>();

    public void getCarsName(){
        System.out.println(GameMessage.REQUEST_ENTER_CAR_NAME_MESSAGE);
        String carNames = Console.readLine();
        String[] carListTest = carNames.split(",");
        for(String car : carListTest){
            carList.add(new Car(car));
        }
    }
}

