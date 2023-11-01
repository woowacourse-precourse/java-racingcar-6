package racingcar.domain;

import java.util.stream.IntStream;

public class Game {
    private Race racingCar;
    private int roundNumber;

    public Game(){
        setUp();
        start();
        presentWinner();
    }

    public void setUp(){
        racingCar = InputHandler.setCars();
        roundNumber = InputHandler.setRoundNumber();
    }

    public void start(){
        InputOutputMessage.printStartMessage();
        IntStream.range(0, roundNumber).forEach(n -> racingCar.playOneRound());
    }

    public void presentWinner(){
        racingCar.getWinner();
    }
}
