package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class RacingCarModel {
    private ArrayList<Car> carList;
    public RacingCarModel(Iterator<String> playerList){
        carList = new ArrayList<>();
        while(playerList.hasNext()){
            Car newCar = new Car(playerList.next());
            carList.add(newCar);
        }
    }

    public Iterator<String> getWinnerList(){
        ArrayList<String> winnerList = new ArrayList<>();
        Collections.sort(carList);
        int maxMoveCount = carList.get(0).getMoveCount();

        for (Car car: carList){
            if (car.getMoveCount() == maxMoveCount){
                winnerList.add(car.getName());
            }
            else{
                break;
            }
        }

        return winnerList.iterator();
    }

    public Iterator<String> getRoundResults(){
        ArrayList<String> roundResults =  new ArrayList<>(carList.size());
        for (Car car: carList){
            roundResults.add(car.toString());
        }
        return roundResults.iterator();
    }

    public void takeStep(){
        for (Car car : carList){
            car.attemptMove();
        }
    }

}
