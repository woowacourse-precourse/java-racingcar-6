package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static racingcar.MessageType.CAR_NAMES;
import static racingcar.MessageType.EXECUTION_RESULT;
import static racingcar.MessageType.FINAL_WINNER;
import static racingcar.MessageType.TRY_COUNT;

public class GameSystem {
    private static final String POSSIBLE_TRY_COUNT_REGEX = "^[1-9][0-9]*$";
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUBER = 9;
    
    public List<Car> cars = new LinkedList<>();
    private String userInput;
    private String resultMessage;
    private String winnerMessage;
    
    public void startGame() {
        print(CAR_NAMES.getMessage());
        userInput = getUserInput();
        setUpCars(userInput);
        
        print(TRY_COUNT.getMessage());
        userInput = getUserInput();
        int tryCount = verfiyTryCount(userInput);
        
        runRace(tryCount);
        print(EXECUTION_RESULT.getMessage());
        print(resultMessage);
        
        executeWinner();
        print(winnerMessage);
    }
    
    private void print(String message) {
        System.out.println(message);
    }
    
    public void setUpCars(String userInput) {
        String[] carNames = separateCarNamesByComma(userInput);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        
        verfiyCarNames();
    }
    
    public int verfiyTryCount(String userInput) {
        if (isNotNumber(userInput)) {
            throw new IllegalArgumentException("Try count is not number.");
        }
        
        return Integer.parseInt(userInput);
    }
    
    private static String getUserInput() {
        return Console.readLine();
    }
    
    public String[] separateCarNamesByComma(String userInput) {
        return userInput.split(",");
    }
    
    private void verfiyCarNames() {
        if (hasDuplicatedName(cars)) {
            throw new IllegalArgumentException("Duplicated car names are exist.");
        }
    }
    
    private boolean hasDuplicatedName(List<Car> cars) {
        Set<String> nonDuplicatedCarNames = new HashSet<>();
        return cars.stream()
                .map(car -> car.name)
                .anyMatch(carName -> !nonDuplicatedCarNames.add(carName)); // 이미 이름이 존재하는 경우 true 반환
    }
    
    private boolean isNotNumber(String userInput) {
        return !userInput.matches(POSSIBLE_TRY_COUNT_REGEX);
    }
    
    private void runRace(int tryCount) {
        StringBuilder resultMessageBuilder = new StringBuilder();
        for (int i = 0; i < tryCount; i++) {
            raceCars();
            makeResultMessageForCars(resultMessageBuilder);
        }
    }
    
    private void raceCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUBER);
            car.go(randomNumber);
        }
    }
    
    private void makeResultMessageForCars(StringBuilder resultMessageBuilder) {
        for (Car car : cars) {
            resultMessageBuilder.append(car.name).append(" : ").append(car.getLocationStatus()).append("\n");
        }
        resultMessageBuilder.append("\n");
        resultMessage = resultMessageBuilder.toString();
    }
    
    private void executeWinner() {
        int maxLocation = calculateMaxLocation();
        determineWinner(maxLocation);
        
        List<Car> winners = findWinners(maxLocation);
        calculateWinnerMessage(winners);
    }
    
    private int calculateMaxLocation() {
        return cars.stream()
                .mapToInt(car -> car.location)
                .max()
                .orElse(0);
    }
    
    private void determineWinner(int maxLocation) {
        cars.stream()
                .filter(car -> car.location == maxLocation)
                .forEach(Car::setWinner);
    }
    
    private List<Car> findWinners(int maxLocation) {
        List<Car> winners = new LinkedList<>();
        
        for (Car car : cars) {
            if (car.isWinner) {
                winners.add(car);
            }
        }
        
        return winners;
    }
    
    private void calculateWinnerMessage(List<Car> winners) {
        StringBuilder winnerMessageBuilder = new StringBuilder();
        String winnerNames = winners.stream()
                .map(car -> car.name)
                .collect(Collectors.joining(", "));
        winnerMessageBuilder.append(FINAL_WINNER.getMessage()).append(" : ").append(winnerNames);
        winnerMessage = winnerMessageBuilder.toString();
    }
}
