package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.entity.Car;
import racingcar.util.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RaceGame {
    private final List<Car> cars;
    private final InputValidator inputValidator;
    private Integer moveCount;
    public RaceGame(){
        this.cars = new ArrayList<>();
        this.inputValidator = new InputValidator();
    }
    public void run(){
        play();
    }
    private void play(){
        inputName();
        inputMoveCount();
        for(int i = 0;i < moveCount;i++){
            for(Car car : cars){
                car.move();
            }
            printCarsPosition();
        }
        printWinner();
    }

    private void inputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> parseResults = parseNamesFromInput(input);
        System.out.println(parseResults);
        if(!inputValidator.validateNumberOfCar(parseResults)){
            throw new IllegalArgumentException("Input Error: Invalid the minimum number of cars");
        }
        for(String result : parseResults){
            if(!inputValidator.validateNameOfLength(result)){
                throw new IllegalArgumentException("Input Error: Invalid name length");
            }
            Car racer = new Car(result);
            cars.add(racer);
        }
    }
    private List<String> parseNamesFromInput(String input){
        String[] parseResultArray = input.split(",");
        // convert array type into list type
        return Arrays.asList(parseResultArray);
    }

    private void inputMoveCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        if(!inputValidator.isNumericValid(input)) {
            throw new IllegalArgumentException("Input Error: moveCount is not numeric");
        }
        Integer numericInput = Integer.parseInt(input);
        if(!inputValidator.isMinValueValid(numericInput)){
            throw new IllegalArgumentException("Input Error: Invalid the minimum number of moveCount");
        }
        this.moveCount = numericInput;
    }

    private void printCarsPosition(){
        String distanceMark = "-";
        for(Car car : cars){
            String name = car.getName();
            String position = distanceMark.repeat(car.getPosition());
            System.out.println(name + " : " + position);
        }
        System.out.println(); // 게임 진행상황 출력 후 줄바꿈
    }

    private void printWinner(){
        List<Integer> positions = new ArrayList<>();
        List<String> winnersList = new ArrayList<>();
        String winnersString; // 우승자 명을 저장할 변수
        Integer maxPosition; // 가장 먼 위치 값을 저장할 변수
        for(Car car : cars){
            positions.add(car.getPosition());
        }
        maxPosition = Collections.max(positions);
        System.out.print("최종 우승자 : ");
        for(Car car : cars){
            Integer eachCarPosition = car.getPosition();
            String eachCarName = car.getName();
            if(eachCarPosition.equals(maxPosition)){
                winnersList.add(eachCarName);
            }
        }
        winnersString = String.join(",", winnersList);
        System.out.println(winnersString);
    }
}
