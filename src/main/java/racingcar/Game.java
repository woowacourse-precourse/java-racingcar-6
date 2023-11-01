package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static final int RANDOM_MINIMUM = 0;
    private static final int RANDOM_MAXIMUM = 9;

    public Game(){
    }

    public void play() {
        String carListInput = getCarNameInput();
        String trialNumberInput = getTrialNumberInput();
        Input input = getInput(carListInput, trialNumberInput);
        printMessage("\n실행 결과");
        List<Car> resultSet = playGameSet(input);
        printFinalResult(resultSet);
    }

    public List<Car> playGameSet(Input input) {
        List<Car> gameState = setStartState(input);
        Integer trialNubmer = input.getTrialNumber();
        for(int i = 0; i < trialNubmer ; i++){
            playGame(gameState);
        }
        return gameState;
    }

    public void playGame(List<Car> gameState){
        gameState = gameState.stream().map(this::pauseOrProgess).toList();
        printEachGameState(gameState);
    }

    public Car pauseOrProgess(Car car){
        int randomNumber = pickNumberInRange(RANDOM_MINIMUM, RANDOM_MAXIMUM);
        if(randomNumber >= 4){
            car.progress();
        }
        return car;
    }

    public void printFinalResult(List<Car> gameState) {
        String winners = findWinners(gameState);
        System.out.print("최종 우승자 : " + winners);
    }

    public String findWinners(List<Car> gameState){
        int maxDistance = gameState.stream()
                .mapToInt(o -> o.getState().length())
                .max()
                .orElse(0);

        String winners = gameState.stream()
                .filter(o -> o.getState().length() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

        return winners;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private String getCarNameInput() {
        printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carListInput = readLine();
        return carListInput;
    }

    private String getTrialNumberInput(){
        printMessage("시도할 회수는 몇회인가요?");
        String trialNumberInput = readLine();
        return trialNumberInput;
    }

    private Input getInput(String carListInput, String trialNumberInput){
        List<String> carList = Arrays.stream(carListInput.split(",")).collect(Collectors.toList());
        Integer trialNumber = Integer.parseInt(trialNumberInput);
        Input input = new Input(carList, trialNumber);
        return input;
    }

    private List<Car> setStartState(Input input){
        List<Car> gameState = new ArrayList<>();
        for(String car : input.getCarList()){
            gameState.add(new Car(car, ""));
        }
        return gameState;
    }

    private void printEachGameState(List<Car> gameState){
        for(Car car : gameState){
            System.out.println(car.getCarName() + " : " + car.getState());
        }
        System.out.println();
    }
}
