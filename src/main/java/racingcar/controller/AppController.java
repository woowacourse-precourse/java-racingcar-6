package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.InputValidate;
import racingcar.model.ScoreBoardGenerator;
import racingcar.view.AppView;

import java.math.BigInteger;
import java.util.ArrayList;


public class AppController {
    public static String[] inputNames;
    public static String inputNumber;
    public static BigInteger totalRound;
    public static ArrayList<Car> cars;

    public AppController () {
        inputNames = null;
        inputNumber = "";
        totalRound = BigInteger.ZERO;
        cars = null;
    }

    public static void init () {
        try {
            inputNames = AppView.inputParticipant().split(",");
            InputValidate.isValidParticipant(inputNames);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        cars = ScoreBoardGenerator.initScoreBoard(inputNames);
    }

    public static void startRacing () {

    }

    public static void startTurnPlay () {

    }

    public static void endRacing () {

    }

    public void run () {
        init();

        startRacing();

        endRacing();
    }
}