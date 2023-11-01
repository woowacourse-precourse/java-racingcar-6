package racingcar.model;

public class RacingCarResult {
    private RacingCarList winners;
    private int maxDistance;

    public RacingCarResult() {
        this.winners = new RacingCarList();
        this.maxDistance = 0;
    }

    public RacingCarList getWinners() {
        return winners;
    }
    public void getFinalWinners(RacingCarList carList) {
        int maxDistance = 0;
        for(int carIndex=0; carIndex < carList.size(); carIndex++){
            RacingCar car = carList.getCar(carIndex);
            int carDistance = car.getDistance();
            if(carDistance > maxDistance){
                winners.clear();
                maxDistance = carDistance;
            }
            if (car.getDistance() == maxDistance){
                winners.add(car);
            }
        }
        this.maxDistance = maxDistance;
    }
}
