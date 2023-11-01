package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.InputValidate;
import racingcar.model.Racing;
import racingcar.model.ScoreBoardGenerator;
import racingcar.view.AppView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;


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
        try {
            inputNumber = AppView.inputNumberOfTurns();
            InputValidate.isValidNumber(inputNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        totalRound = new BigInteger(inputNumber);
    }

    public static void startRacing () {
        AppView.outputStartRacing();

        startTurnPlay();
    }

    public static void startTurnPlay () {
        for (BigInteger i = BigInteger.ZERO; i.compareTo(totalRound) < 0; i = i.add(BigInteger.ONE)) {
            Racing.turnPlaying(cars);
            AppView.outputScoreState(cars);
        }
        if (inputNumber.equals("0")) {
            AppView.outputScoreState(cars);
        }
    }

    public static void endRacing () {
        cars.sort(Comparator.reverseOrder());
        StringBuilder sb = Racing.calculateWinner(cars);

        AppView.outputFinish(sb);
    }

    public void run () {
        init();

        startRacing();

        endRacing();
    }
}