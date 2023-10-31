package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private final CarList carList = new CarList();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void gameStart() {
        inputView.printCarNameInputMessage();

        String carNames = Console.readLine();
        String [] carNamesArray = carList.splitCarNames(carNames);
        carList.addCars(carNamesArray);

        inputView.printAttemptNumberInputMessage();
        int attempt = Integer.parseInt(Console.readLine());

        outputView.printResult();
        IntStream.range(0, attempt)
                .forEach(i -> performCarMovements(carList));

        Winners winners = carList.getWinners();
        outputView.printWinners(winners.getWinningCarNames());
    }

    private void performCarMovements(CarList carList){
        for (Car car : carList.getCarList()) {
            car.stopOrMove();
            outputView.printNameAndDistance(car.getName(), car.getDistance());
        }
        System.out.println();
    }
}