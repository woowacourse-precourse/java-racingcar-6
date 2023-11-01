package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.ConstantUtil.RESULT;
import static racingcar.util.ConstantUtil.START_MESSAGE;
import static racingcar.util.ConstantUtil.TRY_NUMBER;
import static racingcar.util.ConstantUtil.WINNER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/*
1. 이름은 5자 이하만 가능
2. 전진 조건은 무작위수가 4이상일 경우만
 */
public class CarController {
    private final ValidationController validationController = new ValidationController();
    private int maxNumber=0;


    public void startGame() {
        System.out.println(START_MESSAGE);
        String input = readLine();
        String[] stringList = input.split(",");
        for(String name: stringList) {
            validationController.validateNameNumber(name);
        }
        System.out.println(TRY_NUMBER);
        String inputNumber = readLine();

        runCar(stringList, Integer.valueOf(inputNumber));
    }

    private void runCar(String[] carList, int tryNumber) {
        System.out.println(RESULT);
        int[] forwardScore = new int[carList.length];

        for(int i=0; i<tryNumber; i++) {
            forwardScore = makeRandomNumber(forwardScore);
            printResult(carList, forwardScore);
        }
        String result = makeWinner(carList, forwardScore);
        System.out.println(WINNER + result);
    }

    private int[] makeRandomNumber(int[] forwardScore) {
        for(int i=0; i<forwardScore.length; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if(validationController.validateNumber(randomNumber)){
                forwardScore[i]++;
                maxNumber(forwardScore[i]);
            };
        }

        return forwardScore;
    }

    private void printResult(String[] carList, int[] score) {
        for(int i=0; i<carList.length; i++) {
            System.out.println(carList[i] + " : " + "-".repeat(score[i]));
        }
        System.out.println();
    }

    private void maxNumber(int score) {
        if(maxNumber < score) {
            maxNumber = score;
        }
    }

    private String makeWinner(String[] carList, int[] score) {
        List<String> winner = new ArrayList<>();
        for(int i=0; i<carList.length; i++) {
            if(score[i] == maxNumber){
                winner.add(carList[i]);
            }
        }
        String result = String.join(", ", winner);
        return result;
    }

}
