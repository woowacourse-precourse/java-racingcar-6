package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.message.ExceptionMessage.DUPLICATE_CAR_NAME_EXCEPTION_MESSAGE;

public class RacingCar {
    private List<Car> carList = new ArrayList<>();

    public RacingCar(List<String> playerCarNameList) {
        checkForDuplication(playerCarNameList);
        playerCarNameList
                .forEach(playerCarName -> carList.add(new Car(playerCarName)));
    }

    public static void checkForDuplication(List<String> inputCarNameList){
        List<String> uniquelist = inputCarNameList.stream().distinct().collect(Collectors.toList());

        if(inputCarNameList.size()!=uniquelist.size()){
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_EXCEPTION_MESSAGE);
        }

    }


    public void stopOrMoveForward() {
        carList.forEach(racingCar -> racingCar.stopOrMoveForward());
    }

    public List<String> makeDistanceString() {
        return carList
                .stream()
                .map(Car::distanceConvertString)
                .collect(Collectors.toList());
    }

    public List<String> determineWinner() {
        List<String> winnerList = new ArrayList<>();

        Integer maxDistance = this.findMaxDistance();

        carList.forEach(car -> {
            if (car.measureDistance().equals(maxDistance)) {
                winnerList.add(car.getName());
            }
        });

        return winnerList;
    }

    public Integer findMaxDistance(){
        return carList
                .stream()
                .max(Comparator.comparing(car -> car.measureDistance()))
                .get()
                .measureDistance();
    }


}
