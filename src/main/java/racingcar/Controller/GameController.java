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

    public void checkIntOverZero(int n){
        if(n <= 0)
            throw new IllegalArgumentException();
    }

    public int convertStringInteger(String intStr){
        try{
            return Integer.parseInt(intStr);
        }
        catch (Exception e){
            throw new IllegalArgumentException();
        }
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
        view.printSetNumOfAttempt();
        int n = convertStringInteger(Console.readLine());
        checkIntOverZero(n);
        attemptNum = n;
    }

    public void executeGame(){
        for(int i=0;i<attemptNum;i++){
            map.trial();
            view.printMapProcess(map);
        }
        map.calWinner();
        view.printWinner(map.getWinner());
    }
}
