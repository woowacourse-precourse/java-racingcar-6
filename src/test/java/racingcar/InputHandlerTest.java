package racingcar;

class InputHandlerTest {
    @Test
    void validCarNames() {
        String input = "pobi,woni,jun";
        assertDoesNotThrow(() -> InputHandler.validateCarNames(input));
    }

    @Test
    void invalidCarNames() {
        String input = "longname,pobi";
        assertThrows(IllegalArgumentException.class, () -> InputHandler.validateCarNames(input));
    }


}
