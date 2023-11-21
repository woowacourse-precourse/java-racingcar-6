package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.close;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.validation.CarNameValidation;
import racingcar.validation.TryCountValidation;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

class CreateCharacterServiceTest {
    private final InputView inputView;
    private final OutputView outputView;
    private final CreateCharacterService createCharacterService;

    CreateCharacterServiceTest() {
        inputView = new InputView(new CarNameValidation(), new TryCountValidation());
        outputView = new OutputView();
        createCharacterService = new CreateCharacterService(inputView, outputView);
    }

    @BeforeEach
    void setup() {
        close();
    }

    @DisplayName("자동차 객체 생성")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, woni", "pobi,woni,jun"})
    void createCharacterTest(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        List<Car> cars = createCharacterService.createCharacter();

        //then
        for (Car car : cars) {
            Assertions.assertThat(car.getName()).isNotNull();
            Assertions.assertThat(car.getName().length()).isLessThanOrEqualTo(5);
        }
    }
}