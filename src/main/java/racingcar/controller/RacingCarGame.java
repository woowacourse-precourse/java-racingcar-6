package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarGame {
    private static Car cars;
    private static int numberForMoves;

    public void startGame() {
        startUserInput();
        identifyWinners();
    }

    public static void startUserInput() {
        getInputCars();
        getInputNumberForMove();
        racingProgress();
    }

    public static void getInputCars() {
        Output.printStartMessage();
        cars = new Car(Input.inputCarName());
        Validation.validateCarName();
    }

    public static void getInputNumberForMove() {
        Output.printAttemptNumberMessage();
        numberForMoves = Input.inputNumberForMove();
        Validation.validateOneToNine(numberForMoves);
    }

    public static void racingProgress() {
        Output.printResultMessage();
        repeatInputNumberTimes(numberForMoves);
    }

    public static void repeatInputNumberTimes(int inputNumber) {
        for (int i = 0; i < inputNumber; i++) {
            generateAndCheckRandomNumber();
            Output.printRacingProgress();
        }
    }

    public static void generateAndCheckRandomNumber() {
        for (int i = 0; i < cars.getSize(); i++) {
            increaseMovementNumber(i);
        }
    }

    public static void increaseMovementNumber(int index) {
        if (checkNumberIs4Over(generateNumber())) {
            cars.increaseMove(index);
        }
    }

    public static boolean checkNumberIs4Over(int number) {
        return number >= 4;
    }

    public static int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


    public static void identifyWinners() {
        List<Integer> indices = indexOfWinners(Car.getMoves());
        String result = nameOfWinners(indices).toString();
        Output.printWinners(result);
    }

    public static List<Integer> indexOfWinners(List<Integer> winnerMove) {
        int winner = Collections.max(winnerMove);
        List<Integer> indices = IntStream.range(0, winnerMove.size())
                .filter(i -> winnerMove.get(i) == winner)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        return indices;
    }

    public static String nameOfWinners(List<Integer> indices) {
        String result = "";

        for (int i = 0; i < indices.size(); i++) {
            result += (cars.getNames()
                    .get(indices.get(i)) + ", ");
        }

        int lengthForDeleteComma = result.length() - 2;
        return result.substring(0, lengthForDeleteComma);
    }

}
