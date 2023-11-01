package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RaceGameController {
    View view = new View();

    public void start() {
        List<String> carNames = getCarNames();
        System.out.println(carNames);
        int round = getRound();

        RaceGame raceGame = new RaceGame(carNames, round);
        for (int i=0; i<raceGame.getRound(); i++) {
            raceGame.roundStart();
            raceGame.recordResult();
        }
        raceGame.setWinner();

        view.showResult(raceGame.getResult());
        view.showWinner(raceGame.getWinner());
    }

    private List<String> getCarNames() {
        view.showInputCars();
        String carNamesInput = view.getInput();
        validCarNamesInput(carNamesInput);
        List<String> carNamesList = splitCarNamesInput(carNamesInput);
        validCarNamesList(carNamesList);
        return carNamesList;
    }

    private int getRound() {
        view.showInputRound();
        String roundInput = view.getInput();
        validRoundInput(roundInput);
        return Integer.parseInt(roundInput);
    }

    private void validCarNamesInput(String carNamesInput) {
        if (!carNamesInput.contains(",")) {
            throw new IllegalArgumentException();
        }
        if (carNamesInput.contains(",,")) {
            throw new IllegalArgumentException();
        }
        if (carNamesInput.charAt(0) == ',' ||
                carNamesInput.charAt(carNamesInput.length()-1) == ',') {
            throw new IllegalArgumentException();
        }
    }

    private List<String> splitCarNamesInput(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        return Arrays.asList(carNames);
    }

    private void validCarNamesList(List<String> carNamesList) {
        Set<String> carNameSet = new HashSet<>();
        if (carNamesList.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (String carName : carNamesList) {
            // null값 확인
            if (carName == null) {
                System.out.println(carName);
                throw new IllegalArgumentException();
            }
            // 5자리 이상인 car name 확인
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            // 중복된 name 확인
            if (carNameSet.contains(carName)) {
                throw new IllegalArgumentException();
            }
            carNameSet.add(carName);
        }
    }

    private void validRoundInput(String roundInput) {
        try {
            Integer.parseInt(roundInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
