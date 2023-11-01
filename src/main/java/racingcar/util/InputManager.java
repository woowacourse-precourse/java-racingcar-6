package racingcar.util;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {

    public List<Car> getPlayerCarList() throws IllegalArgumentException{
        String carNamesLine = readLine();
        return makePlayerCarList(carNamesLine.split(","));
    }

    public List<Car> makePlayerCarList(String[] carNames) throws IllegalArgumentException{
        List<Car> playerCarList = new ArrayList<>();
        for(String name : carNames){
            if(name.length() > 5) throw new IllegalArgumentException();
            playerCarList.add(new Car(name));
        }
        return playerCarList;
    }

    public int getTryTimes() {
        String tryTimesLine = readLine();
        int tryTimes = 0;
        try{
            tryTimes = Integer.parseInt(tryTimesLine);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return tryTimes;

    }
}
