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

    @Test
    void validRaceCount() {
        String input = "5";
        assertDoesNotThrow(() -> InputHandler.getRaceCount(input));
    }

    @Test
    void invalidRaceCount() {
        String input = "invalid";
        assertThrows(IllegalArgumentException.class, () -> InputHandler.getRaceCount(input));
    }
}
