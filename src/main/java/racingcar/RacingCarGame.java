package racingcar;

public class RacingCarGame {

    private final RacingGameConsoleView view;

    public RacingCarGame(RacingGameConsoleView view) {
        this.view = view;
    }

    public void play() {
        RacingCarNameRegistryDto racingCarNameRegistryDto = view.inputRacingCarNames();
        RacingCarRegistry racingCarRegistry = racingCarNameRegistryDto.toRacingCarRegistry();

        MoveCountDto moveCountDto = view.inputMoveCount();
        MoveCount moveCount = moveCountDto.toMoveCount();
    }
}
