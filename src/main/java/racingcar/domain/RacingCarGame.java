package racingcar.domain;

import java.util.List;

public class RacingCarGame {
    private int number;
    private boolean timeOver;
    private List<RacingCar> racingCarList;

    public RacingCarGame(int number, boolean timeOver, List<RacingCar> racingCarList){
        this.number = number;
        this.timeOver = timeOver;
        this.racingCarList = racingCarList;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public boolean isTimeOver() {
        return timeOver;
    }

    public void setTimeOver(){
        if(this.number==0){
            this.timeOver=false;
        }
    }

    public void setNumber(){
        this.number -=1;
    }

    public void repeatMovingRacingCar(){
        racingCarList.stream().forEach(RacingCar::moveRacingCar);
        setNumber();
        setTimeOver();
    }


    public String whoIsWinner() {
        return racingCarList.stream()
                .filter(car -> car.getMove() == winnerValue())
                .map(RacingCar::getName)
                .reduce((name1, name2 ) ->name1 + "," + name2)
                .orElse("");
    }
    private Integer winnerValue(){
        return racingCarList.stream()
                .mapToInt(RacingCar::getMove)
                .max()
                .orElse(0);
    }


}
