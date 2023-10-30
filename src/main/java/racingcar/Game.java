package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    final int COUNT_MINIMUM_CAR = 2;
    final String SEPARATOR_CAR_NAME = ",";
    public List<Car> carList;
    public List<String> winnerList;
    public int roundNumber;
    public GameStatus gameStatus;
    public ErrorMessages errorType;

    public Game() {
        this.carList = new ArrayList<Car>();
        this.winnerList = new ArrayList<String>();
        this.roundNumber = 0;
        gameStatus = GameStatus.READY_TO_INPUT_CARNAMES;
    }

    public void startGame() {
        while (gameStatus != GameStatus.END_OF_RACING_GAME) {
            proceedNextStep(gameStatus);
        }
    }

    public void proceedNextStep(GameStatus status) {
        switch (status) {
            case READY_TO_INPUT_CARNAMES:
                inputCarsName();
                break;
            case READY_TO_INPUT_ROUNDNUMBER:
                inputRoundNumber();
                break;
            case START_PROCEED_EACH_ROUND:
                proceedEachRound();
                break;
            case COMPLETE_TOTAL_ROUND:
                selectWinner();
                break;
            case COMPLETE_SELECT_WINNER:
                announceWinner();
                break;
        }
    }

    public void inputCarsName() {

        System.out.print(GameMessages.MESSAGE_START.getMessage());
        String inputNames = Console.readLine();

        if (inputNames == null) {
            errorType = ErrorMessages.NOT_ENOUGH_CAR_NUMBER;
            throw new IllegalArgumentException(COUNT_MINIMUM_CAR + errorType.getDescription());
        }

        String[] arrayNames = inputNames.split(SEPARATOR_CAR_NAME);
        List<String> carNameList = Arrays.asList(arrayNames);

        if (!validateCarNamesLength(carNameList)) {
            errorType = ErrorMessages.NOT_ENOUGH_CAR_NUMBER;
            throw new IllegalArgumentException(COUNT_MINIMUM_CAR + errorType.getDescription());
        }

        if (!validateCarNameDuplication(carNameList)) {
            errorType = ErrorMessages.CONTAIN_DUPLICATE_CARNAME;
            throw new IllegalArgumentException(errorType.getDescription());
        }

        createCarList(carNameList);

        gameStatus = GameStatus.READY_TO_INPUT_ROUNDNUMBER;
    }

    public void inputRoundNumber() {
        System.out.print(GameMessages.MESSAGE_ASK_TRY.getMessage());
        String inputRoundNumber = Console.readLine();

        validateIsOnlyNumber(inputRoundNumber);
        validateIsGraterZero(inputRoundNumber);

        gameStatus = GameStatus.START_PROCEED_EACH_ROUND;
    }

    private void createCarList(List<String> carNameList) {
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    public void proceedEachRound() {
        System.out.print(GameMessages.MESSAGE_RACE_RESULT.getMessage());

        for (int i = 0; i < roundNumber; i++) {
            for (Car car : carList) {
                car.runCar();
            }

            System.out.println();
        }

        gameStatus = GameStatus.COMPLETE_TOTAL_ROUND;
    }

    public void selectWinner() {
        Car winnerFirst = carList.stream().max(Comparator.comparing(Car::getForwardCount)).get();

        for (Car car : carList) {
            if (car.getForwardCount() == winnerFirst.getForwardCount()) {
                winnerList.add(car.getCarName());
            }
        }

        gameStatus = GameStatus.COMPLETE_SELECT_WINNER;
    }

    public void announceWinner() {
        String winnerListWithComma = String.join(", ", winnerList);
        System.out.print(GameMessages.MESSAGE_ANNOUNCE_WINNER.getMessage() + winnerListWithComma);
        gameStatus = GameStatus.END_OF_RACING_GAME;
    }

    public boolean validateCarNameDuplication(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);

        if (nameSet.size() == nameList.size()) {
            return true;
        }

        return false;
    }

    public boolean validateCarNamesLength(List<String> nameList) {
        if (nameList.size() >= COUNT_MINIMUM_CAR) {
            return true;
        }

        return false;
    }

    public void validateIsOnlyNumber(String inputNumber) {
        try {
            roundNumber = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            errorType = ErrorMessages.NOT_NUMBER;
            throw new IllegalArgumentException(errorType.getDescription());
        }
    }

    private void validateIsGraterZero(String inputNumber) {
        if (inputNumber == null) {
            errorType = ErrorMessages.NOT_OVER_ZERO;
            throw new IllegalArgumentException(errorType.getDescription());
        }

        int resultNumber = Integer.parseInt(inputNumber);

        if (resultNumber <= 0) {
            errorType = ErrorMessages.NOT_OVER_ZERO;
            throw new IllegalArgumentException(errorType.getDescription());
        }

        roundNumber = resultNumber;
    }
}
