package racingcar.domain;

import java.util.List;

public class RacingGame {
    private List<RacingCar> cars;
    private List<String> winners;

    public void setRacingCar(RacingCar car){
        this.cars.add(car);
    }

    public List<String> getWinners(){
        return winners;
    }

    public void setWinners(List<String> winners){
        this.winners = winners;
    }

    public void findWinner(){
    }
}
