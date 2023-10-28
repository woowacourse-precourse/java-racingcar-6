package racingcar;

public class Racing {
    static DataInputOutput dataSet = new DataInputOutput();
    public void initializeRacing(){
        dataSet.printSystemMessage("START");
        dataSet.userInputCarsInfo();
        dataSet.printSystemMessage("INPUT_MOVING");
        dataSet.userInputMovingInfo();
    }
    public void doRacing(){
        while (dataSet.getNumTotalMoving() >= 0){
            if(dataSet.makeRandomNumber()) {
                for (Car car : dataSet.carList) {
                    car.movingCar();
                }
            }
            dataSet.setNumtotalMoving(dataSet.getNumTotalMoving() - 1);
        }
    }
    public void getWinner(){}
}
