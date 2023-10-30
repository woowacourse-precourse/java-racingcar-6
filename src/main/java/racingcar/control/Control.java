package racingcar.control;


import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Control {
    private static int rounds;
    // 여기 Control 클래스는 private으로 최대한 써보자! -> 어차피 Model, View로 못 나가니까!
    // main 메서드인 playGame() 먼저 만들고 후에 이 클래스 내에서 나누기
    // Cars 입력받고 List에 넣어주는 메서드도 여기서 구현할 것
    // Winner 판별하는 메서드도 여기
    public void playGame() {

        startGame();
        raceProcess();
        OutputView.printWinner();
    }

    private static void startGame() {
        String input = InputView.requestCarName();
        Validation.validateNameInput(input);
        Cars.carNames = Cars.makeCarList(input);
        // 라운드 수 입력 받기
        String roundInput = InputView.requestRoundNumber();
        Validation.validateNumberInput(roundInput);
        rounds = Integer.parseInt(roundInput);
    }


    private static void raceProcess() {
        Cars.putObject();

        System.out.print("실행 결과");
        for (int i = 1; i <= rounds; i++) {
            System.out.println();

            for (Car car : Cars.cars) {
                car.move();
                OutputView.printRacingProcess(car.getName(), car.getPosition());
            }
        }
    }
}
