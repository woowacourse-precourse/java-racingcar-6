package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.Car;
import racingcar.Model.RacingMap;
import racingcar.View.View;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    View view;
    RacingMap map;
    int attemptNum;

    public GameController(View view, RacingMap map){
        this.view = view;
        this.map = map;
    }

    public void checkCarNameLength(String carName){
        if(carName.length() > 5 || carName.isEmpty())
            throw new IllegalArgumentException();
    }

    public void setCarString(){
        view.printSetCarString();
        String carString = Console.readLine();
        List<Car> carList = new ArrayList<>();
        for(String carName: carString.split(",")){
            checkCarNameLength(carName);
            carList.add(new Car(carName));
        }
        map.setCarList(carList);
    }

    public void setNumOfAttemp(){

    }
}
