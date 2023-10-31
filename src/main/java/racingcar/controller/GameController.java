package racingcar.controller;

import racingcar.model.RandomValueGenerator;
import racingcar.service.FindWinner;
import racingcar.service.SaveInputValue;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    static List<String> cars = new ArrayList<>();
    static String repeatNumber;
    static List<Integer> moveInfo = new ArrayList<>();

    RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
    FindWinner findWinner = new FindWinner();
    SaveInputValue saveInputValue = new SaveInputValue(cars, repeatNumber);
    OutputView outputView = new OutputView();

    public void startGame() {
        cars = saveInputValue.saveCarName();
        repeatNumber = saveInputValue.saveRepeatNumber();
        initializeMoveInfo();
        play();
    }

    public void initializeMoveInfo() {
        moveInfo = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            moveInfo.add(0);
        }
    }

    public void play() {
        outputView.showResultMessage();
        for (int i = 0; i < Integer.parseInt(repeatNumber); i++) {
            move();
            showAllCarProcess();
        }
        outputView.showWinnerMessage();
        showWinner();
    }

    public void move() {
        List<Integer> randomNumberInfo = eachRandomNumber();
        for (int i = 0; i < cars.size(); i++) {
            if (randomNumberInfo.get(i) >= 4) {
                moveInfo.set(i, moveInfo.get(i) + 1);
            }
        }
    }

    public List<Integer> eachRandomNumber() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            result.add(randomValueGenerator.getRandomValue());
        }
        return result;
    }

    public void showMove(int idx) {
        int moveNumber = moveInfo.get(idx);
        for (int i = 0; i < moveNumber; i++) {
            System.out.print("-");
        }
    }

    public void showEachCarProcess(int idx) {
        System.out.print(cars.get(idx) + " : ");
        showMove(idx);
        System.out.println("\r");
    }

    public void showAllCarProcess() {
        for (int i = 0; i < cars.size(); i++) {
            showEachCarProcess(i);
        }
        System.out.println("\r");
    }

    public void showWinner() {
        List<String> name = findWinner.getWinnerInfo(moveInfo, cars);
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i));
            if (i != name.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
