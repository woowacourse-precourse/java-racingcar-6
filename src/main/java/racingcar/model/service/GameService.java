package racingcar.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.domain.Car;
import racingcar.model.domain.Game;
import racingcar.model.repository.GameRepository;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static final int FROM_START = 0;//0부터 9까지
    private static final int TO_END = 9;
    private static final int MOVE_FORWARD_CONDITION = 4;

    private static final int MIN_VALUE = -1;

    private final GameRepository gameRepository = new GameRepository();//생성자 가져

    public void play(Game game){//Game이라는 클래스가 game이라는 매개변수에 할당
        moveForardRandomNum(game);
        game.increaseTrialNum();

    }
    public List<String> getWinners(Game game) {
        List<Car> cars = game.getCars();
        int maxPosition = getMaxPosition(cars);
        return getMaxPositionCars(cars, maxPosition);
    }

    public Boolean isEnd(Game game){
        return gameRepository.isEnd(game);

    }
    public Long save(Game game){
        return gameRepository.save(game);
    }
    private List<String>getMaxPositionCars(List<Car> cars, int maxPosition){
        List<String>carNames = new ArrayList<>();
        for (Car car: cars){
            if (car.getPosition()==maxPosition){
                carNames.add(car.getName());
            }
        }
        return carNames;
    }
    private int getMaxPosition(List<Car>cars){
        int max = MIN_VALUE;
        for (Car car : cars){
            if (max < car.getPosition()){
                max = car.getPosition();
            }
        }
        return max;
    }
    private void moveForardRandomNum(Game game){
        for (Car car: game.getCars()){
            if(MOVE_FORWARD_CONDITION <= getRandomNumber()){
                car.moveForward(1);
            }
        }
    }
     private int getRandomNumber(){
        return Randoms.pickNumberInRange(FROM_START,TO_END);
     }
}
