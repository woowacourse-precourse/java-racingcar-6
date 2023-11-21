package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.model.Car;
import racingcar.model.TryCount;
import racingcar.validation.CarNameValidation;
import racingcar.validation.TryCountValidation;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

/**
 * 랜덤값 포함 테스트... 어떻게 짤까?
 */
class RacingGameServiceTest extends NsTest {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    RacingGameServiceTest() {
        inputView = new InputView(new CarNameValidation(), new TryCountValidation());
        outputView = new OutputView();
        racingGameService = new RacingGameService(inputView, outputView);
    }

    @DisplayName("게임 결과 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "pobi; 10",
            "pobi,woni; 3",
            "pobi,woni,jun; 5",
    }, delimiter = ';')
    void playGameTest(String input, int inputTryCount) {
        //given
        List<Car> cars = createCars(input);

        //when
        racingGameService.playGame(cars, new TryCount(inputTryCount));

        //then
//        String output = output();
//        int pobiCount = output.split("pobi : ").length - 1;
//
//        System.out.println("pobiCount = " + pobiCount);
//
//        Assertions.assertThat(pobiCount).isEqualTo(inputTryCount);

    }


    @DisplayName("최종 우승자가 1명인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi,woni", "pobi,woni,jun",})
    void OnlyOneWinner(String input) {
        //given
        List<Car> cars = createCars(input);
        cars.stream().filter(car -> car.getName().equals("pobi"))
                .forEach(Car::move);

        //when
        racingGameService.findWinner(cars);

        //then
        assertThat(output()).isEqualTo("최종 우승자 : pobi");
    }

    @DisplayName("최종 우승자가 2명인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni", "pobi,woni,jun",})
    void TwoWinner(String input) {
        //given
        List<Car> cars = createCars(input);
        cars.stream().filter(car -> car.getName().equals("pobi"))
                .forEach(Car::move);

        cars.stream().filter(car -> car.getName().equals("woni"))
                .forEach(Car::move);

        //when
        racingGameService.findWinner(cars);

        //then
        assertThat(output()).isEqualTo("최종 우승자 : pobi,woni");
    }


    private static List<Car> createCars(String input) {
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            String character = name.trim();
            Car car = new Car(character);
            cars.add(car);
        }

        return cars;
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}