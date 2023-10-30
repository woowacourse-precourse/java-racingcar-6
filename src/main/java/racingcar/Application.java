package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String names = inputView.inputCarName();
        List<String> nameList = inputView.splitNames(names);

        int round = inputView.inputTryNumber();

        List<Car> carList = mappingCar(nameList);
        Racing racing = new Racing(carList);

        Map<String, List<Integer>> result = racing.startRacing(round);

        outputView.roundResult(result, round);

        List<String> winner = racing.determineWinner();
        outputView.getWinnerMessage(winner);
    }

    private static List<Car> mappingCar(List<String> nameList) {
        List<Car> carList = new ArrayList<>();

        for(int i = 0; i< nameList.size(); i++){
            Car car = new Car(nameList.get(i), 0);
            carList.add(car);
        }

        return carList;
    }
}
