package racingcar.model;

import racingcar.util.MessageFactory;
import racingcar.util.MessageProcessor;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> cars;
    private final int tryCount;
    private final MessageProcessor messageProcessor;

    public Game(List<Car> cars, int tryCount, MessageProcessor messageProcessor) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(MessageFactory.invalidTryCountMessage);
        }
        this.cars = cars;
        this.tryCount = tryCount;
        this.messageProcessor = messageProcessor;
    }

}
