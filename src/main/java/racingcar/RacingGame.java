package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    private List<Car> cars;
    private Integer turn;
    private Judge judge;

    public RacingGame(int maxNameLength, int forwardCriterion, int lowerBoundRandomNumber, int upperBoundRandomNumber) {
        cars = new ArrayList<>();
        turn = 0;
        judge = new Judge(maxNameLength, forwardCriterion, lowerBoundRandomNumber, upperBoundRandomNumber);
    }

    public void play(){
        this.cars = setCars();
        this.turn = setTurn();
        System.out.println();
        iterRun();
        finish();
    }

    private List<Car> setCars() {
        printQuestionAskingNames();
        Optional<String> input = askCarNames();
        judge.isEffectiveInputNames(input);
        return makeCars(input);
    }

    private void printQuestionAskingNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private Optional<String> askCarNames() {
        return Optional.ofNullable(Console.readLine());
    }

    private List<Car> makeCars(Optional<String> input) {
        List<String> inputs = Arrays.stream(input.get().split(",")).toList();

        List<Car> cars = new ArrayList<>();
        inputs.forEach(str -> cars.add(new Car(str)));
        return cars;
    }


    private Integer setTurn() {
        printQuestionAskingTurn();
        Optional<String> inputTurn = askTurn();
        judge.isEffectiveInputTurn(inputTurn);
        return convertTypeToInteger(inputTurn);
    }

    private void printQuestionAskingTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private Optional<String> askTurn() {
        return Optional.ofNullable(Console.readLine());
    }

    private Integer convertTypeToInteger(Optional<String> inputTurn) {
        return Integer.parseInt(inputTurn.get());
    }

    private void iterRun(){
        System.out.println("실행 결과");

        for(int i=0; i<turn; i++) {
            playOneTurn();
            printCarsStatus();
            System.out.println();
        }
    }

    private void playOneTurn() {
        cars.forEach(car -> {
            if(judge.canMove()){
                car.incrementForwardCount();
            }
        });
    }

    private void printCarsStatus() {
        cars.forEach(car -> car.showStatus());
    }

    private void finish() {
        List<Car> finalWinners = getFinalWinners();
        printFinalWinners(finalWinners);
    }

    private List<Car> getFinalWinners() {
        List<Car> winners = new ArrayList<>();

        Integer maxForward = 0;
        for (Car car : cars) {
            if(maxForward < car.getForwardCount()){
                maxForward = car.getForwardCount();
            }
        }

        for (Car car : cars) {
            if(car.getForwardCount() == maxForward){
                winners.add(car);
            }
        }
        return winners;
    }

    private void printFinalWinners(List<Car> winners) {
        StringBuilder finalWinners = new StringBuilder();
        finalWinners.append(winners.get(0).getName());
        winners.remove(0);

        for (Car winner : winners) {
            finalWinners.append(", "+winner.getName());
        }

        System.out.println("최종 우승자 : "+finalWinners);
    }
}
