package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GameSystem {
    private static final String INSERT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INSERT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String POSSIBLE_TRY_COUNT_REGEX = "^[1-9][0-9]*$";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUBER = 9;
    
    public List<Car> cars = new LinkedList<>();
    private String userInput;
    private StringBuilder resultMessage;
    
    public void startGame() {
        System.out.println(INSERT_CAR_NAMES);
        userInput = getUserInput();
        setUpCars(userInput);
        
        System.out.println(INSERT_TRY_COUNT);
        userInput = getUserInput();
        int tryCount = verfiyTryCount(userInput);
        
        runRace(tryCount);
        System.out.println(EXECUTION_RESULT);
        System.out.print(resultMessage);
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
        resultMessage = new StringBuilder();
        for (int i = 0; i < tryCount; i++) {
            raceCars();
            makeResultMessageForCars(resultMessage);
        }
    }
    
    private void raceCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUBER);
            car.go(randomNumber);
        }
    }
    
    private void makeResultMessageForCars(StringBuilder result) {
        for (Car car : cars) {
            result.append(car.name).append(" : ").append(car.movingDistance).append("\n");
        }
        result.append("\n");
    }
}
