package racingcar.gamefield;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.car.Car;
import racingcar.car.CarNameDto;
import racingcar.system.SystemConstant;

public class DisplayBoard {

    private Map<CarNameDto, String> currentCarPosition;

    DisplayBoard(List<String> carNameList){
        this.currentCarPosition = new HashMap<>(carNameList.size());
        for (String carName : carNameList) {
            currentCarPosition.put(new CarNameDto(carName),"");
        }
    }

    public StringBuilder displayCurrentCarPosition(){
        StringBuilder displayBoard = new StringBuilder();
        for (CarNameDto carNameDto : currentCarPosition.keySet()) {
            displayBoard.append(carNameDto.getCarName()).append(" : ").append(currentCarPosition.get(carNameDto)).append("\n");
        }
        return displayBoard;
    }

    public void updateCurrentCarPosition(Car car){
        for (CarNameDto carNameDto : currentCarPosition.keySet()) {
            if(car.isNameEquals(carNameDto)){
                currentCarPosition.replace(carNameDto, currentCarPosition.get(carNameDto) + SystemConstant.POSITION_EXPRESSION);
            }
        }
    }
}
