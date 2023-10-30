package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.entity.Car;
import racingcar.util.InputValidator;

import java.util.Arrays;
import java.util.List;

public class RaceGame {
    private List<Car> cars;
    private Integer moveCount;
    private InputValidator inputValidator;
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
    }

    private void inputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> parseResults = parseNamesFromInput(input);
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
    }
}
