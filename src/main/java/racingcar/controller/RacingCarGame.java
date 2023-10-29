package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private OutputView outputView = OutputView.getInstance();
    private InputView inputView = InputView.getInstance();
    private Cars cars = new Cars();

    public void run(){
        carInitialize();
        int tryNumber = inputView.InputTryNumber();
        playRacingGame(tryNumber);
    }

    public void playRacingGame(int tryNumber) {
        for(int tryCount = 0; tryCount < tryNumber;tryCount++){
            pickEachCarRandomNumber();
        }
    }

    public void pickEachCarRandomNumber() {
        Map<String, Car> carsMap = cars.getCars();
        for (Car car : carsMap.values()) {
            int randomNumber = pickRandomNumber();
        }
    }

    public int pickRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void carInitialize() {
        String carNames = inputView.InputCarNames();
        List<String> carNameList = carList(carNames);
        cars.makeCarsFromCarList(carNameList);
    }

    public List<String> carList(String carNames){
        String[] carNameList = carNames.split("");
        return List.of(carNameList);
    }
}
