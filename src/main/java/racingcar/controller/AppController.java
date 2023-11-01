package racingcar.controller;

import racingcar.model.Car;

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
