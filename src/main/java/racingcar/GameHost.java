package racingcar;

import java.util.Collection;

public class GameHost {

    Collection<Car> carList;

    private GameHost(Collection<Car> cars) {
        this.carList = cars;
    }

    public void playOneTurn() {
        carList.forEach((Car::moveForward));
        printAfterOneTurn();
    }

    private void printAfterOneTurn() {
        carList.forEach((car -> System.out.println(car.toString())));
    }

    public static GameHost addCars(Collection<Car> cars) {
        return new GameHost(cars);
    }

    public String announceWinner(){
        int maxOdometer = getMaxOdometer();
        return getWinner(maxOdometer);
    }

    private int getMaxOdometer() {
        int maxOdometer = 0;
        for (Car car : carList) {
            if(maxOdometer < car.getOdometer()) {
                maxOdometer = car.getOdometer();
            }
        }
        return maxOdometer;
    }

    private String getWinner(int maxOdometer) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            if(maxOdometer == car.getOdometer()) {
                sb.append(car.getName()).append(",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
