package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.Game;

import java.util.ArrayList;

public class Racepreparations {

    Cars cars = new Cars();
    InputValidation inputValidation = new InputValidation();

    public Racepreparations(){}
    // 1. 사용자로부터 자동차의 이름을 입력 받는다
    public void askCarNames(){
        String InputCars = Console.readLine();
        String[] splitCarNames = inputValidation.splitNamesByComma(InputCars);

        ArrayList<String> saveCarNames = new ArrayList<>();
        for(int i=0;i<splitCarNames.length;i++){
            saveCarNames.add(splitCarNames[i]);
        }

        cars.setCarNames(saveCarNames);
    }
    // 2. 사용자로 부터 경주차가 이동을 시도할 횟수를 입력받는다.
    public void askExecuteCount() throws IllegalArgumentException{
        String inputCount = Console.readLine();

        if(inputValidation.isInt(inputCount)){
            cars.setRaceCount(Integer.parseInt(inputCount));
        }else if(!inputValidation.isInt(inputCount)){
            throw new IllegalArgumentException();
        }
    }

}
