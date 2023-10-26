package racingcar.controller;

import racingcar.model.Input;
import racingcar.util.Counter;
import racingcar.util.Recorder;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;

import java.util.List;

public class GameController {
    InputMessage inputMessage;
    OutputMessage outputMessage;
    Input input;
    List<String> car;
    int lap;
    int[] now;

    public void readyGame() {
        inputMessage.carName();
        car = input.car();
        inputMessage.lap();
        lap = input.lap();
    }

    public void startGame() {
        Recorder recorder = new Recorder();
        now = recorder.record(car, lap);
    }

    public void endGame() {
        Counter counter = new Counter();
        int max = counter.maxCount(now);
        now=counter.eliminate(now, max);
        outputMessage.result(car, now);
    }
}
