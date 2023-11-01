package racingcar;

class InputHandlerTest {
    @Test
    void validCarNames() {
        String input = "pobi,woni,jun";
        assertDoesNotThrow(() -> InputHandler.validateCarNames(input));
    }


}
