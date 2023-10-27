package race;

import action.Car;
import action.CarGenerator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import view.InputView;
import view.OutputView;

public class Race {

    private CarGenerator carGenerator;
    private List<Car> carList;

    public Race() {
        carGenerator = new CarGenerator(InputView.inputCarName());
        carList = carGenerator.makeCars();
    }

    public void run() {
        int tryNumber = Integer.parseInt(InputView.askTryNumber());
        OutputView.result();

        for (int i = 0; i < tryNumber; i++) {
            for (Car car : carList) {
                car.action();
                OutputView.printResult(car);
            }
            System.out.println();
        }

        getWinner();
    }

    public void getWinner() {
        int length = getMaxLength();
        List<String> winners = new LinkedList<>();

        for (Car car : carList) {
            if (car.getStatus().length() == length) {
                winners.add(car.getCarName());
            }
        }
        OutputView.printWinner(winners);
    }

    public int getMaxLength() {
        int length = 0;
        for (Car car : carList) {
            length = Math.max(car.getStatus().length(), length);
        }

        return length;
    }
}
