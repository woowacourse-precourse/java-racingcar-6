package racingcar.controller;

import racingcar.domain.UserInput;

public class Game {

    public void start() {
        play();
    }

    public static void play() {
        UserInput.inputCarName();
    }
    
}
