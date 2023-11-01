package racingcar.controller;

import java.util.List;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.model.Playing;

public class RacingPlayController {
    private final Input input;
    private final Output output;
    private Playing playing;

    public RacingPlayController() {
        this.input = new Input();
        this.output = new Output();
    }

    public void play() {
        List<String> racingCarNames = input.getInputRacingCarNames();
        int tryTimes = input.getInputTryTimes();
        playing = new Playing(racingCarNames, tryTimes);

        output.printResultMessage();
        playRacing();
        output.printFinalRacingResult(playing.getResult());
    }

    public void playRacing() {
        while (playing.playStatus()) {
            playing.play();
            output.printRacingResult(playing.getRacingCarsStatus());
        }
    }

}
