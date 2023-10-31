package racingcar.controller;

import racingcar.model.CarDto;
import racingcar.model.GameSettingsDto;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<CarDto> carInformationList;

    public RacingGame(){
        carInformationList = new ArrayList<>();
    }

    public void startRacingGame(GameSettingsDto gameSettingsDto){
        setCarInformation(gameSettingsDto.getCarsName());
    }

    private void setCarInformation(List<String> carsName){
        for(int i = 0; i < carsName.size(); i++){
            carInformationList.add(new CarDto(carsName.get(i),0));
        }
    }
}
