package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingGame {
    private static final String GET_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private int attemptsNumber;
    private List<Car> cars;
    private List<Car> winners;
    private List<String> winnerNames;

    RacingGame(){
        cars = new ArrayList<>();
        winners = new ArrayList<>();
        winnerNames = new ArrayList<>();
    }
    public void startGame(){
        addCarsFromUserInput();
        getNumberOfAttempts();
        playGame();
        findWinner();
        printWinner();
    }
    private String getUserInput() {
        return readLine();
    }
    private void addCarsFromUserInput() {
        System.out.println(GET_NAME_MESSAGE);
        String input = getUserInput();

        String[] names = input.split(",");

        for (String name : names) {
            cars.add(new Car(name));
        }
    }
    private void getNumberOfAttempts() {
        System.out.println(GET_NUMBER_MESSAGE);
        String number = getUserInput();
        attemptsNumber = Integer.parseInt(number);
    }
    private int getRandomNumber() {
        return pickNumberInRange(0,9);
    }
    private boolean checkRandomNumber(int randomNumber) {
        return randomNumber >= 4;
    }
    private void moveCarByRandomNumber(Car car){
        int RandomNumber = getRandomNumber();
        if (checkRandomNumber(RandomNumber)) car.move();
    }
    private void playOneRound(){
        for(Car car : cars)
            moveCarByRandomNumber(car);
    }
    private void printResult(){
        for(Car car : cars)
            car.printCarPosition();
    }
    private void playGame(){
        System.out.println(RACE_RESULT_MESSAGE);
        for(int i = 0; i < attemptsNumber; i++){
            playOneRound();
            printResult();
            System.out.println();
        }
    }
    private void findWinner(){
        winners.add(cars.get(0));

        for (Car car : cars){
            int comparison = car.compareCarPosition(winners.get(0));
            if(comparison > 0){
                winners.clear();
                winners.add(car);
            }
            if(comparison == 0 && !winners.contains(car))
                winners.add(car);
        }
    }
    private String makeWinnerNameString(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.getName());
        }
        return String.join(", ", winnerNames);
    }
    private void printWinner(){
        System.out.print(WINNER_MESSAGE);
        System.out.println(makeWinnerNameString(winners));
    }
}