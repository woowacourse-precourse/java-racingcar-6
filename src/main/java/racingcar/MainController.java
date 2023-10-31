package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    private OutputView outputView;
    private InputView inputView;
    private Race race;

    public MainController() {
        outputView = new OutputView();
        inputView = new InputView();
        race = new Race();
    }

    public void startGame() {
        generateCars();
    }

    private void generateCars() {
        try {
            List<String> carsList = inputView.getCarNamesInput();
            race.registerCar(carsList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("잘못된 값을 입력하였으므로 프로그램이 종료됩니다.");
        }
    }
}
