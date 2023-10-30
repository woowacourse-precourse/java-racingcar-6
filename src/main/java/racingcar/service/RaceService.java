package racingcar.service;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;

import racingcar.domain.Cars;
import racingcar.view.SystemOutMessage;
import racingcar.view.UserInputMessage;

public class RaceService {
    Cars cars = new Cars();

    public void ParticipateRace(){
        UserInputMessage.askParticipants();
        String InputCars = Console.readLine();
        splitCarNames(InputCars);

    }
    //기능1-(1) 자동차 이름 쉼표로 분리하기
    public void splitCarNames(String InputCars) throws IllegalArgumentException{
        String[] splitCarNames = InputCars.split(",");

        if(!isLimitFiveChar(splitCarNames)){
            throw new IllegalArgumentException();
        }
        cars.setCarNames(splitCarNames);
    }
    //기능1-예외: 자동차 이름이 5자가 넘어갈 때
    public boolean isLimitFiveChar(String[] CarNames)throws IllegalArgumentException {
        for(int i=0;i<CarNames.length;i++) {
            if (CarNames[i].length() > 5) {
                return false;
            }
        }
        return true;
    }

    //기능1-(2). 실행횟수 입력받기
    public void askTryCount() throws IllegalArgumentException{
        UserInputMessage.askExecuteNumber();
        String inputCount = Console.readLine();

        if(isInt(inputCount)){
            cars.setRaceCount(Integer.parseInt(inputCount));
        }else if(!isInt(inputCount)){
            throw new IllegalArgumentException();
        }
    }

    public boolean isInt(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
