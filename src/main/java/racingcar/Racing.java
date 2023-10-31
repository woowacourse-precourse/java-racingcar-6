package racingcar;

import java.util.ArrayList;
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
            moveCar(dataSet.carList);
            dataSet.setNumtotalMoving(dataSet.getNumTotalMoving() - 1);
            dataSet.printMovingResult();
        }

        getWinner();
    }

    public void moveCar(List<Car> carList){
        for (Car car : carList) {
            if(dataSet.makeRandomNumber()) {
                car.carInfoUpdate();
            }
        }
    }

    public void getWinner(){
        CarSorting carSort = new CarSorting();
        List<String> winnerList = new ArrayList<>();
        List<Car> tempCarList = new ArrayList<>(dataSet.carList);

        // 1.Sort Car List to Get Winner
        // 2.Get Biggest Moving Counts for Printing Results
        tempCarList.sort(carSort);
        int biggestMovingCount = tempCarList.get(0).getMovingCount();

        for(Car car: dataSet.carList){
            if(car.getMovingCount() == biggestMovingCount){
                winnerList.add(car.getCarName());
            }
        }

        dataSet.printWinner(winnerList);
    }
}
