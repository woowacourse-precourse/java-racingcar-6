package racingcar.controller;

import racingcar.model.CarDto;
import racingcar.model.GameSettingsDto;

import java.util.ArrayList;
import java.util.List;

import static racingcar.controller.RandomNumber.generateRandomNumber;
import static racingcar.utility.Constants.MIN_REQUIRED_ADVANCEMENT;

public class RacingGame {
    private List<CarDto> carInformationList;

    public RacingGame(){
        carInformationList = new ArrayList<>();
    }

    public void startRacingGame(GameSettingsDto gameSettingsDto){
        setCarInformation(gameSettingsDto.getCarsName());

        for(int i = 0; i < carInformationList.size(); i++){
            if(isRandomNumberBiggerOrEqualFour(generateRandomNumber())){
                setAdvancementCount(i);
            }
        }
    }

    private void setCarInformation(List<String> carsName){
        for(int i = 0; i < carsName.size(); i++){
            carInformationList.add(new CarDto(carsName.get(i),0));
        }
    }

    private boolean isRandomNumberBiggerOrEqualFour(int randomNumber){
        if(MIN_REQUIRED_ADVANCEMENT <= randomNumber){
            return true;
        }
        return false;
    }

    private void setAdvancementCount(int index){
        carInformationList.get(index).setAdvancementCount(carInformationList.get(index).getAdvancementCount() + 1);
    }

}