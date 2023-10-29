package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.GameRepository;

import java.util.ArrayList;
import java.util.List;


public class GameService {

    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;
    private static final int MIN_FORWARD_NUMBER = 4;
    private static final int MIN_POSITION_NUMBER = -1;

    private final List<String> getMaxCarNames = new ArrayList<>();

    private final GameRepository gameRepository = new GameRepository();


    public void playOneGame(Game game){
        moveOneStepForward(game);
        game.increaseTrialNumber();
    }

    public Boolean isGameEnd(Game game){
        return game.checkTrialEqualsToTrialCount();
    }

    public Long saveGame(Game game) {
        return gameRepository.save(game);
    }

    public List<String> getWinner(Game game){
        List<Car> cars = game.getCars();
        int maxPosition = getMaxPosition(cars);
        return getMaxPositionCars(cars,maxPosition);
    }


    private List<String> getMaxPositionCars(List<Car> cars, int maxPosition) {
       getMaxCarNames.clear();
        for (Car car : cars) {
            if (car.getCarPosition() == maxPosition) {
                getMaxCarNames.add(car.getCarName());
            }
        }
        return getMaxCarNames;
    }

    private int getMaxPosition(List<Car> cars){
        int max = MIN_POSITION_NUMBER;
        for(Car car : cars){
            if(max < car.getCarPosition()){
                max = car.getCarPosition();
            }
        }
        return max;
    }


    private void moveOneStepForward(Game game){
        for(Car car : game.getCars()){
            if(MIN_FORWARD_NUMBER <= getRandomNumber()){
                car.moveForward(1);
            }
        }
    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE,MAX_NUMBER_RANGE);
    }


}
