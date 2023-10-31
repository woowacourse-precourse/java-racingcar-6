package racingcar.controller;

import java.util.ArrayList;
import racingcar.exception.CarException;
import racingcar.exception.TryException;
import racingcar.model.Car;
import racingcar.service.GameService;
import racingcar.view.Input;
import racingcar.view.Print;

public class GameController {

    private Input input = new Input();
    private Print print = new Print();
    private CarException carException = new CarException();
    private TryException tryException = new TryException();
    private GameService gameService = new GameService();

    private ArrayList<Car> carList = new ArrayList<>();

    public int gameSetting() {
        print.message("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = input.carNames().split(",");
        for (int i = 0; i < carNames.length; i++) {
            carException.format(carNames[i]);
            carList.add(new Car(carNames[i]));
        }

        print.message("시도할 회수는 몇회인가요?");
        String tryCount = input.tryCount();
        tryException.format(tryCount);
        return Integer.parseInt(tryCount);
    }

    public void startGame() {
        int tryCount = gameSetting();
        System.out.println();
        print.message("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            gameService.tryRacing(carList);
            print.result(carList);
        }
        print.message(gameService.getWinner(carList));
    }

}


