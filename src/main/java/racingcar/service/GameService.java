package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.OutputConsole;
import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameService {
    List<Car> cars;
    int trial;
    public GameService(List<Car> cars, int trial){
        this.cars = cars;
        this.trial = trial;
    }

    public void playRace(){
        for(int i = 0; i < trial; i++){
            getScoreOrNot();
            System.out.println(" ");
        }
    }
    private void getScoreOrNot(){
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.increaseScore();
            }
        }
        OutputConsole.printScores(cars);
    }

    public List<String> getWinners() throws IllegalArgumentException{
        int maxScore = cars.stream().map(Car::getScore).max(Integer::compare).orElseThrow();
        return IntStream.range(0, trial)
                .filter(i -> cars.get(i).getScore() == maxScore)
                .mapToObj(i->cars.get(i).getName())
                .collect(Collectors.toList());
    }
}
