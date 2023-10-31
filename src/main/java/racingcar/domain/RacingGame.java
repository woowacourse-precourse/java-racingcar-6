package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.PerGameCarResultDto;

public class RacingGame {
    private final int totalTryCnt;
    private int curTryCnt;
    private int maxWinCnt;
    private List<Car> cars;

    public RacingGame(List<String> carNames, int totalTryCnt){
        createCars(carNames);
        this.totalTryCnt = totalTryCnt;
    }

    public void createCars(List<String> carNames){
        cars = new ArrayList<>();
        for (String name : carNames){
            cars.add(new Car(name));
        }
    }

    public List<PerGameCarResultDto> startRacingGame(){
        List<PerGameCarResultDto> resultDtos = new ArrayList<>();
        for (Car car : cars){
            maxWinCnt = Math.max(maxWinCnt, car.race());
            resultDtos.add(car.getCarStatus());
        }
        curTryCnt += 1;
        return resultDtos;
    }

    public List<Car> getRacingWinner(){
        List<Car> winners = new ArrayList<>();
        for (Car car : cars){
            if(car.isWinner(maxWinCnt)){
                winners.add(car);
            }
        }
        return winners;
    }

    public boolean isEndGame(){
        return totalTryCnt == curTryCnt;
    }

}
