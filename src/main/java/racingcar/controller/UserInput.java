package racingcar.controller;

import racingcar.model.GameSettingsDto;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    private List<String> carsNameList;
    private int racingCount;

    private InputException inputException;

    public UserInput(){
        inputException = new InputException();
    }

    public GameSettingsDto readUserGameSettingInput(){
        splitCarNameStringToList(readCarsName());
        readRacingCount();
        return new GameSettingsDto(carsNameList,racingCount);
    }

    private String readCarsName(){
        String carsName;

        carsName = readLine();
        inputException.carsNameException(carsName);

        return carsName;
    }

    private void readRacingCount(){
        racingCount = Integer.parseInt(readLine()); // int형으로 변환
        inputException.isVaildRacingCount(racingCount);
    }

    private void splitCarNameStringToList(String carsName){
        carsNameList = List.of(carsName.split(",")); //자동차 이름을 불변리스트에 저장
    }
}
