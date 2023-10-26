package racingcar.controller;

import racingcar.model.Input;
import racingcar.util.Counter;
import racingcar.util.Recorder;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    InputMessage inputMessage = new InputMessage();
    OutputMessage outputMessage = new OutputMessage();
    Input input = new Input();
    List<String> car = new ArrayList<>();
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
        now = counter.eliminate(now, max);
        outputMessage.result(car, now);
    }
}
