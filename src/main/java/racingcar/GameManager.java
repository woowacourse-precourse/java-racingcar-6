package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameManager {
    Input input = new Input();

    public List<Car> carSetting() {
        Output.printInputCarMessage();
        List<String> carNameList = input.getCarNameList();
        List<Car> carList = new ArrayList<>();

        IntStream.range(0, carNameList.size()).forEach(i -> carList.add(new Car(carNameList.get(i))));

        return carList;
    }

    public int tryCountSetting() {
        Output.printInputTryCountMessage();
        return input.getTryCount();
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<String> checkWinner(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        int maxPosition = findMaxPosition(carList);

        for (Car car : carList) {
            if (maxPosition == car.getPosition()) {
                winnerList.add(car.getCarName());
            }
        }

        return winnerList;
    }

    private int findMaxPosition(List<Car> carList) {
        int max = -1;

        for (Car car : carList) {
            if (max <= car.getPosition()) {
                max = car.getPosition();
            }
        }

        return max;
    }
}
