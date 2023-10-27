package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import racingcar.util.ConvertUtil;

public class CarGame {

    private List<Car> cars;
    private int gameCount;

    public CarGame(String carNames, int gameCount){
        cars = ConvertUtil.convertStrToListCar(carNames);
        this.gameCount = gameCount;
    }

    public void movePosition(){
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if(randomNum >=4){
                car.addPosition();
            }
        }
    }

    public List<Car> findWinner(){
        return cars.stream().filter(car -> car.getPosition() == findMaxPosition()).toList();
    }

    private int findMaxPosition(){
        return cars.stream().map(Car::getPosition).max(Integer::compareTo).orElseThrow(IllegalArgumentException::new);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getGameCount() {
        return gameCount;
    }
}
