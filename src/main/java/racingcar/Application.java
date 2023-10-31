package racingcar;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();
        Validator validator = Validator.getInstance();
        GameManager gameManager = GameManager.getInstance();

        String inputCarList = inputView.inputCarList();
        validator.validateInputCarList(inputCarList);
        List<Car> carList = gameManager.setCarList(inputCarList);

        String inputRoundNum = inputView.inputRoundNum();
        validator.validateInputRoundNum(inputRoundNum);
        int roundNum = gameManager.setRoundNum(inputRoundNum);

        outputView.printResult();

        while (true) {
            if(gameManager.checkGameFinished(roundNum)){
                break;
            }
            gameManager.moveCar(carList);
            outputView.printRoundResult(carList);

            roundNum--;
        }
        List<Car> maxCarList = gameManager.checkWinner(carList);
        outputView.printWinner(maxCarList);
    }
}

