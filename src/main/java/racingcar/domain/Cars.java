package racingcar.domain;


import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.response.GameResultDto;
import racingcar.util.ExceptionHandler;
import racingcar.view.ConsoleOutput;
import racingcar.view.OutputView;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void playGame() {
        for (Car car : carList) {
            checkNumberAndMoveCar(car);
            printCarInfo(car);
        }
        ConsoleOutput.printNewLine();
    }

    private void checkNumberAndMoveCar(Car car) {
        int randomNumber = Computer.createRandomNumber();
        if (checkNumberOverThree(randomNumber)) {
            car.moveCar();
        }
    }

    private boolean checkNumberOverThree(int number) {
        return number > 3;
    }

    private void printCarInfo(Car car) {
        OutputView outputView = new OutputView();
        outputView.printRoundResult(car.getCarInfo());
    }

    public GameResultDto getWinner() {
        int maxLocation = getMaxLocation();
        List<String> winners = getWinners(maxLocation);
        return new GameResultDto(winners);
    }

    private int getMaxLocation() {
        return carList.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(ExceptionHandler::throwIfCarNotFound);
    }

    private List<String> getWinners(int maxLocation) {
        return carList.stream()
                .filter(car -> car.isSameLocation(maxLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
