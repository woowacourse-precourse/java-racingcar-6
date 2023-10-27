package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

class InputViewTest {

    private ConsoleProvider mockProvider;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        mockProvider = Mockito.mock(ConsoleProvider.class);
        inputView = new InputView(mockProvider);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "gim,lee,park", "lee,jun,ho"})
    void 입력받은_자동차_이름들을_CarNames_객체로_반환하는지_테스트(String input) {
        when(mockProvider.provide()).thenReturn(input);

        CarNames expectedCarNames = new CarNames(input);
        CarNames actualCarNames = inputView.readCarNames();

        assertEquals(expectedCarNames, actualCarNames);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "gim,lee,park", "lee,jun,ho"})
    void CarNames객체의_내부_CarName_객체들이_예상대로_저장되는지_테스트(String input) {
        CarNames carNames = new CarNames(input);
        List<CarName> expectedCarNames = Arrays.stream(input.split(","))
                .map(CarName::new)
                .collect(Collectors.toList());

        List<CarName> actualCarNames = carNames.names();

        assertEquals(expectedCarNames, actualCarNames);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "gim,lee,park", "lee,jun,ho"})
    void 입력된_자동차_이름이_쉼표로_정상적으로_구분되는지_테스트(String input) {
        when(mockProvider.provide()).thenReturn(input);
        CarNames carNames = inputView.readCarNames();
        assertEquals(input, carNames.formatNames());
    }
}