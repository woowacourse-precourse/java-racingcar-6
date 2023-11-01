package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingGroup;
import racingcar.service.Register;

public class Race {

    Register register;
    RacingGroup racingGroup;
    int chance;

    private final String ASK_CHANCE_MESSAGE = "시도할 횟수를 입력해주세요.";
    private final String WINNER_MESSAGE = "최종 우승자 : ";

    public Race() {
        this.register = new Register();
    }

    public void start() {
        makeRacingGroup();
        setChance();
        while (chance-- > 0) {
            race();
        }
        printResult();
    }

    private void printResult() {
        String winners = findWinners();
        System.out.println(WINNER_MESSAGE + winners);
    }

    private String findWinners() {
        int winnersLocation = getWinnersLocation();
        List<String> winners = new ArrayList<>();
        for (Car car : racingGroup.getCars()) {
            if (winnersLocation == car.getLocation()) {
                winners.add(car.getName());
            }
        }
        return String.join(",", winners);
    }

    private int getWinnersLocation() {
        List<Car> cars = racingGroup.getCars();
        Collections.sort(cars, Comparator.comparing(Car::getLocation).reversed());
        return cars.get(0).getLocation();
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
