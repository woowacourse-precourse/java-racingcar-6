package racingcar.domain.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.CarInfo;
import racingcar.domain.car.CarMovementDecider;
import racingcar.dto.Car;
import racingcar.view.OutputView;

public class GameEngine {
    private static final CarInfo carInfo = CarInfo.getInstance();

    public void processTurn() {
        for (Car currentCar : carInfo.getAllCarInfo()) {
            CarMovementDecider decider = new CarMovementDecider(currentCar);

            printStatusOfRaceCar(currentCar.name(), decider.decideMovement());
        }
    }

    public void findWinner() {
        List<Car> participantList = carInfo.getAllCarInfo();

        int maxPosition = participantList.stream()
                .mapToInt(Car::position)
                .max()
                .orElseThrow(() -> new IllegalStateException("차량 목록이 비어있습니다."));

        List<Car> winnerList = participantList.stream()
                .filter(car -> car.position() == maxPosition)
                .toList();

        printGameWinner(winnerList);
    }

    private void printStatusOfRaceCar(String name, Integer position) {
        OutputView.printOutputMessage(name + " : " + "-".repeat(position));
    }

    private void printGameWinner(List<Car> winnerCar) {
        OutputView.printOutputMessageOfGameWinner();
        String result = winnerCar.stream()
                .map(Car::name)
                .collect(Collectors.joining(", "));
        OutputView.printOutputMessage(result);
    }

//    public static void printGameWinner(List<Car> winnerCar) {
//        String result = winnerCar.stream()
//                .map(Car::name)
//                .collect(Collectors.joining(", "));
//        System.out.println(OUTPUT_MESSAGE_OF_GAME_WINNER + result);
//    }
}

