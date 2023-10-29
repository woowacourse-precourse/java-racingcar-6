package racingcar.controller;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RacingCarControllerTest {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

//
//    @Test
//    public void 전진_또는_정지_하라() {
//        // Arrange
//        RacingCarController controller = new RacingCarController(inputView, outputView);
//        Car car = new Car("Car1");
//
//        // Act
//        int initialPosition = car.getPosition();
//        controller.moveForwardOrStop(car, 4); // 4 이상일 때 전진
//        controller.moveForwardOrStop(car, 3); // 3 이하일 때 멈춤
//        controller.moveForwardOrStop(car, 9); // 4 이상일 때 전진
//        int finalPosition = car.getPosition();
//
//        // Assert
//        System.out.println(initialPosition);
//        assertThat(initialPosition).isEqualTo(0); // 처음 위치는 1
//        System.out.println(finalPosition);
//        assertThat(finalPosition).isEqualTo(2);   // 4 이상일 때 1 증가
//    }
//
//    @Test
//    public void 레이싱카를_생성하라() {
//        // Arrange
//        RacingCarController controller = new RacingCarController(inputView, outputView);
//
//        // Act
//        RacingCars racingCars = controller.createRacingCars(List.of("Cara", "Card", "Care"));
//
//        // Assert
//        assertThat(racingCars.getCars()).hasSize(3); // 3대의 자동차
//    }
//
//    @Test
//    public void 게임_진행_결과를_출력하라() {
//        RacingCarController controller = new RacingCarController(inputView, outputView);
//        List<String> userInputCars = List.of("pobi", "prao", "nana");
//        RacingCars racingCars = controller.createRacingCars(userInputCars);
//        List<Car> carList;
//        int count = 3;
//        for (int gameCount = 0; gameCount < count; gameCount++) {
//            carList = controller.onceRace(racingCars);
//            for (int carIndex = 0; carIndex < carList.size(); carIndex++) {
//                outputView.printCarResult(carList.get(carIndex).getName(), carList.get(carIndex).getPosition());
//            }
//        }
//    }
//
//    @Test
//    void 우승자를_출력하라 () throws Exception {
//        RacingCarController controller = new RacingCarController(inputView, outputView);
//        List<String> userInputCars = List.of("pobi", "prao", "nana");
//        RacingCars racingCars = controller.createRacingCars(userInputCars);
//        List<Car> carList = racingCars.getCars();
//        int count = 3;
//        for (int gameCount = 0; gameCount < count; gameCount++) {
//            carList = controller.onceRace(racingCars);
//            for (int carIndex = 0; carIndex < carList.size(); carIndex++) {
//                outputView.printCarResult(carList.get(carIndex).getName(), carList.get(carIndex).getPosition());
//            }
//        }
//        List<String> winners = controller.getWinners(carList);
//        outputView.printWinner(winners);
//    }
}
