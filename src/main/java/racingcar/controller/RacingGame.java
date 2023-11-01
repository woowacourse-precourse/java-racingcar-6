package racingcar.controller;

import racingcar.model.CarDto;
import racingcar.model.GameSettingsDto;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.controller.RandomNumber.generateRandomNumber;
import static racingcar.utility.Constants.MIN_REQUIRED_ADVANCEMENT;

public class RacingGame {
    private List<CarDto> carInformationList;

    public RacingGame(){
        carInformationList = new ArrayList<>();
    }

    public List<CarDto> runRaceIterations(GameSettingsDto gameSettingsDto){
        setCarInformation(gameSettingsDto.getCarsName());

        OutputView.getInstance().printExecutionResultMessage();

        for(int i = 0; i < gameSettingsDto.getRacingCount(); i++){
            startRacingGame();
        }

        return carInformationList;
    }

    private void setCarInformation(List<String> carsName){
        for(int i = 0; i < carsName.size(); i++){
            carInformationList.add(new CarDto(carsName.get(i),0));
        }
    }

    private void startRacingGame(){
        for(int i = 0; i < carInformationList.size(); i++){
            if(isRandomNumberBiggerOrEqualFour(generateRandomNumber())){
                setAdvancementCount(i);
            }
        }

        OutputView.getInstance().printExecutionResult(carInformationList);
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