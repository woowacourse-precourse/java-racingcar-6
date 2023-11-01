package racingcar;

import racingcar.controller.RaceManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        RaceManager race = new RaceManager();
        race.setCarNames();
        race.setAttemptNumber();
        race.printResult();
        race.printWinner();
    }
}
