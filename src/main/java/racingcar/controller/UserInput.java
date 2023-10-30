package racingcar.controller;

import racingcar.model.GameSettingsDto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    private String carsName;
    private int racingCount;

    public UserInput(){}

    public GameSettingsDto readUserGameSettingInput(){
        readCarsName();
        readRacingCount();
        return new GameSettingsDto(carsName,racingCount);
    }

    private void readCarsName(){
        carsName = readLine();
    }

    private void readRacingCount(){
        racingCount = Integer.parseInt(readLine()); // int형으로 변환
    }
}
