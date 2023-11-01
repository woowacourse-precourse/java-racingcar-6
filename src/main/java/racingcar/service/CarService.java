package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.views.InputView;
import racingcar.views.OutputView;

import java.util.List;

public class CarService {

    public List<Car> cars;
    public Integer num;

    public void inputGame(){
        OutputView.inputCarMessage();
        cars = InputView.inputCarName();
        OutputView.inputNumMessage();
        num = InputView.inputGameTry();
    }

    public void racingGame() {
        OutputView.raceResultMessage();

        for (int i = 0; i < num; i++) {
            for(Car c : cars) {
                int randomNumber = Randoms.pickNumberInRange(0,9);
                if (randomNumber >= 4) {
                    c.addMove();
                }
            }
            for (Car c : cars) {
                OutputView.raceResult(c.getName(), c.getRace());
            }
            System.out.println();
        }
    }

    public void outputGame() {
        //String[] winners = cars.racingWinners();

        //OutputView.raceWinnerMessage(winners);
    }


}
