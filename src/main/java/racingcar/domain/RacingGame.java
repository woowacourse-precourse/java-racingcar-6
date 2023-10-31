package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;
    private int tryNum = 0;

    public RacingGame(List<Car> cars, int tryCount){
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<Car> getCars(){
        return cars;
    }

    public void increaseTryNum(){
        this.tryNum += 1;
    }

    public boolean checkGameFinished(){
        return this.tryNum == this.tryCount;
    }

    public void racingOnce(){
        for (Car car : cars){
            car.moveForward();
        }
    }

    public List<Car> getWinners(){
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    private int getMaxPosition(){
        int maxPosition = Integer.MIN_VALUE;

        for(Car car : cars){
            int position = car.getPosition();
            if(position > maxPosition){
                maxPosition = position;
            }
        }
        return maxPosition;
    }

}
