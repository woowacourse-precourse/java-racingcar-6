package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

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
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void 입력받은_자동차_이름을_CarName_객체로_반환하는지_테스트(String input) {
        when(mockProvider.provide()).thenReturn(input);
        assertEquals(new CarName(input), inputView.readCarName());
    }
}