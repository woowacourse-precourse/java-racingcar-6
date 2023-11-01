package racingcar.Function;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.GameRepository;

public class Function {
    private static final int START_STATUS = 0;
    private static final int END_STATUS = 9;
    private static final int FORWARD_CONDITION = 4;
    private static final int DISTANCE = 1;
    private final GameRepository gameRepository = new GameRepository();
    //실제 play 기능
    public void play(Game game) {
        moveRunForward(game);
        game.increaseTrialNumber();
    }
    //전진 기능
    private void moveRunForward(Game game) {
        for (Car car : game.getCars()) {
            if (FORWARD_CONDITION <= getRandomNumber()) {
                car.moveForward(DISTANCE);
            }
        }
    }
    //전진 확률
    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_STATUS, END_STATUS);
    }
    public List<String> getWinners(Game game) {
        List<Car> cars = game.getCars();
        int maxPosition = getMaxPosition(cars);
        return getMaxPosition_Cars(cars, maxPosition);
    }
    //최종 시행 횟수에 도달 했는지 확인 기능을 하는 함수
    public boolean isEnd(Game game) {
        return gameRepository.isEnd(game);
    }
    //시행 차수 마다 저장 하는 기능
    public long save(Game game) {
        return gameRepository.save(game);
    }
    //가장 멀리 간 자동차를 찾는 기능
    private int getMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }
    //우승한 자동차를 찾는 기능
    private List<String> getMaxPosition_Cars(List<Car> cars, int maxPosition) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }
}