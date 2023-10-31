package racingcar.gamefield;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.car.Car;
import racingcar.car.CarNameDto;
import racingcar.car.CarPositionDto;

public class DisplayBoard {

    private Map<CarNameDto, CarPositionDto> currentCarPosition;

    public DisplayBoard() {
        this.currentCarPosition = new LinkedHashMap<>();
    }

    public StringBuilder displayCurrentCarPosition() {
        StringBuilder displayBoard = new StringBuilder();
        for (CarNameDto carNameDto : currentCarPosition.keySet()) {
            displayBoard.append(carNameDto.getCarName())
                    .append(" : ")
                    .append(currentCarPosition.get(carNameDto).getPosition())
                    .append("\n");
        }
        return displayBoard;
    }

    public void initCarPosition(List<String> carNameList) {
        for (String carName : carNameList) {
            currentCarPosition.put(new CarNameDto(carName), new CarPositionDto());
        }
    }

    public void updateCurrentCarPosition(Car car) {
        for (CarNameDto carNameDto : currentCarPosition.keySet()) {
            if (car.isNameEquals(carNameDto)) {
                currentCarPosition.replace(carNameDto, car.wrapCarPosition());
            }
        }
    }

    public List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (CarNameDto carNameDto : currentCarPosition.keySet()) {
            if(currentCarPosition.get(carNameDto).getPositionLength() == maxPosition){
                winnerList.add(carNameDto.getCarName());
            }
        }
        return winnerList;
    }

    private int getMaxPosition(){
        CarPositionDto maxCarPositionDto = currentCarPosition.values().stream()
                .max(Comparator.comparingInt(CarPositionDto::getPositionLength))
                .get();
        return maxCarPositionDto.getPositionLength();
    }

}
