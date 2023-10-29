package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.entity.Car;
import racingcar.util.InputValidator;

import java.util.Arrays;
import java.util.List;

public class RaceGame {
    private List<Car> cars;
    private List<Integer> positions;
    private InputValidator inputValidator;
    public void run(){

    }
    private void play(){

    }
    private void inputName(){
        String input = Console.readLine();
        List<String> parseResults = parseNamesFromInput(input);
        if(!validateNumberOfCar(parseResults)){
            throw new IllegalArgumentException("Input Error: Invalid the minimum number of cars");
        }
        for(String result : parseResults){
            if(!validateNameOfLength(result)){
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

    // 경주에 참여하는 자동차가 최소 2대 이상인지 확인하는 메서드
    private Boolean validateNumberOfCar(List<String> candidateCars){
        return candidateCars.size() >= 2;
    }

    private Boolean validateNameOfLength(String name){
        Boolean isMinLengthValid = inputValidator.isMinLengthValid(name);
        Boolean isMaxLengthValid = inputValidator.isMaxLengthValid(name);
        return (isMinLengthValid && isMaxLengthValid);
    }
}
