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

    public int tryCountSetting(){
        Output.printInputTryCountMessage();
        return input.getTryCount();
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
