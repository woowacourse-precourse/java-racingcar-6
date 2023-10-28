package racingcar.domain;

import java.util.List;

public class Winners {
    private final List<RacingCar> cars;
    private List<RacingCar> winners;

    public Winners(List<RacingCar> cars) {
        this.cars = cars;
        setWinners();
    }

    public List<RacingCar> getWinners(){
        return winners;
    }

    public void setWinners(){
        int max = findMax();
        for (RacingCar car : cars){
            addWinner(max, car);
        }
    }

    public void addWinner(int max, RacingCar car){
        int carMove = car.getMove();
        if (max == carMove){
            winners.add(car);
        }
    }

    public int findMax(){
        int max = RacingCar.defaultValue;
        for(RacingCar car : cars){
            int carMove = car.getMove();
            max = updateMax(max, carMove);
        }
        return max;
    }

    public int updateMax(int max, int value){
        if (max < value){
            max = value;
        }
        return max;
    }
}
