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
            throw new IllegalArgumentException("carName length is not in 1~5");
    }

    public void checkIntOverZero(int n){
        if(n <= 0)
            throw new IllegalArgumentException("int is minus");
    }

    public int convertStringInt(String intStr){
        try{
            return Integer.parseInt(intStr);
        }
        catch (Exception e){
            throw new IllegalArgumentException("can't convert String to int");
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
        int n = convertStringInt(Console.readLine());
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
