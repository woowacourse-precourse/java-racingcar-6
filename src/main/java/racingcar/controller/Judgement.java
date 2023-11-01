package racingcar.controller;

import racingcar.model.CarDto;
import racingcar.model.WinnerDto;

import java.util.ArrayList;
import java.util.List;

import static racingcar.utility.Constants.MIN_ADVANCEMENT_COUNT;

public class Judgement {
    private List<CarDto> carInformationList;
    public Judgement(){}

    public WinnerDto judgeWinner(List<CarDto> carInformationList){
        this.carInformationList = carInformationList;

        return new WinnerDto(findWinnerCarName(findMaxValue()));
    }

    private int findMaxValue(){
        int maxAdvancementCount = MIN_ADVANCEMENT_COUNT;

        for(int i = 0; i < carInformationList.size(); i++){
            if(isMaxCount(carInformationList.get(i).getAdvancementCount(), maxAdvancementCount){
                maxAdvancementCount = carInformationList.get(i).getAdvancementCount();
            }
        }

        return maxAdvancementCount;
    }

    private boolean isMaxCount(int carAdvancementCount, int maxAdvancementCount){
        if(carAdvancementCount > maxAdvancementCount){
            return true;
        }
        return false;
    }

    private List<String> findWinnerCarName(int maxAdvancementCount){
        List<String> winnerList = new ArrayList<>();

        for(int i = 0; i < carInformationList.size(); i++){
            if(isEqual(carInformationList.get(i).getAdvancementCount(), maxAdvancementCount)){
                winnerList.add(carInformationList.get(i).getCarName());
            }
        }

        return winnerList;
    }

    private boolean isEqual(int carAdvancementCount, int maxAdvancementCount){
        if(carAdvancementCount == maxAdvancementCount){
            return true;
        }
        return false;
    }
}
