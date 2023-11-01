package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
    private List<Car> carList = new ArrayList<>();

    public RacingCar(List<String> playerCarNameList){
        playerCarNameList
                .forEach( playerCarName-> carList.add(new Car(playerCarName)));
    }


    public void stopOrMoveForward(){
        carList.forEach(racingCar -> racingCar.stopOrMoveForward());
    }

    public List<String> distanceString(){
        return carList
                .stream()
                .map(Car :: distanceConvertString)
                .collect(Collectors.toList());
    }

    public List<String>  determineWinner(){
        List<String> winnerList = new ArrayList<>();

        Integer maxDistance = carList
                .stream()
                .max(Comparator.comparing(car -> car.measureDistance()))
                .get()
                .measureDistance();

        carList.forEach(car ->{
            if(car.measureDistance().equals(maxDistance)){
                winnerList.add(car.getName());
            }
        });

        return winnerList;
    }



}
