package service;

import camp.nextstep.edu.missionutils.Randoms;

import domain.Car;
import domain.Game;
import repository.GameRepository;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int FORWARD_CONDITION = 4;

    private final GameRepository gameRepository = new GameRepository();

    public void play(Game game) {
        moveForwardByRandomNumber(game);
        game.increaseCurrentTrial();
    }

    private void moveForwardByRandomNumber(Game game) {
        for(Car car : game.getCarList()) {
            if(FORWARD_CONDITION <= getRandomNumber()) {
                car.moveForward(1);
            }
        }
    }

    public List<String> getWinner(Game game) {
        List<Car> carList = game.getCarList();
        int maxLocation = getMaxLocation(carList);
        return getMaxLocationCarList(carList, maxLocation);
    }

    private List<String> getMaxLocationCarList(List<Car> carList, int maxLocation) {
        List<String> carNameList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getLocation() == maxLocation) {
                carNameList.add(car.getCar_name());
            }
        }
        return carNameList;
    }

    private int getMaxLocation(List<Car> carList) {
        int max = -1;
        for(Car car : carList) {
            if (max < car.getLocation()) {
                max = car.getLocation();
            }
        }
        return max;
    }

    public Boolean isEnd(Game game) {
        return gameRepository.isEnd(game);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    public Long save(Game game) {
        return gameRepository.save(game);
    }
}
