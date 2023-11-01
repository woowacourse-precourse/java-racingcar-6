package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.RacingGroup;
import racingcar.service.Register;

public class Race {

    Register register;
    RacingGroup racingGroup;
    int chance;

    private final String ASK_CHANCE_MESSAGE = "시도할 횟수를 입력해주세요.";

    public Race() {
        this.register = new Register();
    }

    public void start() {
        makeRacingGroup();
        setChance();
        while (chance-- > 0) {
            race();
        }
    }

    private void race() {
        for (Car car : racingGroup.getCars()) {
            car.moveForward();
            car.printLocation();
        }

    }

    private void makeRacingGroup() {
        racingGroup = register.set();
    }

    private void setChance() {
        printAskChanceMessage();
        String input = getUserInput();
        chance = inputToNumber(input);
    }

    private String getUserInput() {
        return Console.readLine().trim();
    }

    private int inputToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수를 숫자로 입력해주세요.");
        }
    }

    private void printAskChanceMessage() {
        System.out.println(ASK_CHANCE_MESSAGE);
    }
}
