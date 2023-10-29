package racingcar;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private LinkedHashMap<String, Integer> cars = new LinkedHashMap<>();
    private Integer roundCount;

    public List<String> processCarNames(String carNames){
        List<String> carList = splitAndConvertToList(carNames, ",");
        for(String carName : carList){
            checkCarNameLength(carName);
        }
        return carList;
    }

    public void storeCarNames(List<String> carList){
        for(String carName : carList){
            addCar(carName);
        }
    }

    public List<String> splitAndConvertToList(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    public String getCarNamesInput(){
        return Console.readLine();
    }

    public void checkCarNameLength(String carName){
        if(carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void addCar(String playerName){
        cars.put(playerName, 0);
    }

    public LinkedHashMap<String, Integer> getCars(){
        return cars;
    }

    public String getRoundCountInput(){
        return Console.readLine();
    }

    public void checkIfNumeric(String userInput){
        if(!userInput.matches("[0-9]+"))
            throw new IllegalArgumentException();
    }

    public void setRoundCount(String userInput){
        roundCount = Integer.parseInt(userInput);
    }

    public Integer getRoundCount(){
        return roundCount;
    }
}
