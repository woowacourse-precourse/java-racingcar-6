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
        //TODO 시도 횟수 입력받기
        return 0;

    }


}
