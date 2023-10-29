package racingcar;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Racing {
    static DataInputOutput dataSet = new DataInputOutput();
    public void initializeRacing(){
        dataSet.printSystemMessage("START");
        dataSet.userInputCarsInfo();
        dataSet.printSystemMessage("INPUT_MOVING");
        dataSet.userInputMovingInfo();
    }
    public void doRacing(){
        while (dataSet.getNumTotalMoving() > 0){
                for (Car car : dataSet.carList) {
                    if(dataSet.makeRandomNumber()) {
                        car.movingCar();
                    }
                }
            dataSet.setNumtotalMoving(dataSet.getNumTotalMoving() - 1);
            dataSet.printMovingResult();
        }
        getWinner();
    }
    public void getWinner(){
        CarSorting carSort = new CarSorting();
        List<String> winnerList = new ArrayList<>();
        List<Car> tempCarList = new ArrayList<>(dataSet.carList);
        tempCarList.sort(carSort);
        int maxMovingCount = tempCarList.get(0).getMovingCount();

        for(Car car: dataSet.carList){
            if(car.getMovingCount() == maxMovingCount){
                winnerList.add(car.getCarName());
            }
        }

        dataSet.printWinner(winnerList);
    }
}
