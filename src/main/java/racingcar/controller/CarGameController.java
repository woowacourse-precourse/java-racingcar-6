package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.RacingCar;
import racingcar.service.Circuit;
import racingcar.view.UserInputOutput;

public class CarGameController {

    private final UserInputOutput userInputOutput;

    // 참조 객체는 registerCars() 메서드에서 생성 됩니다
    private Circuit circuit;

    public CarGameController(UserInputOutput userInputOutput) {
        this.userInputOutput = userInputOutput;
    }

    public void run() {
        registerCars();
        startMatch();
        getWinner();
    }

    private void registerCars() {
        String carsName = userInputOutput.inputCarsName();
        circuit = new Circuit(generatedRacingCars(carsName));
    }

    private void startMatch() {
        int count = Integer.parseInt(userInputOutput.inputCount());
        userInputOutput.printResult();
        for (int i = 0; i < count; i++) {
            circuit.run();
            circuit.printCarsTrace();
        }
    }

    private void getWinner() {
        String winner = circuit.getWinner();
        userInputOutput.printWinner(winner);
    }

    private List<Car> generatedRacingCars(String carsName) {
        return Arrays.stream(carsName.replaceAll("\\s", "").split(","))
                .map(RacingCar::of)
                .collect(Collectors.toList());
    }

}
