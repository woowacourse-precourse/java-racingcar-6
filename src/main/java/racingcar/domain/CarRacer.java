package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacer {
    private List<Car> participants = new ArrayList<>();

    public void addParticipant(Car car) {
        participants.add(car);
    }

    public List<Car> getParticipants() {
        return participants;
    }

    private void createCar(List<String> cars){
        for(String carName : cars){
            addParticipant(new Car(carName, 0));
        }
    }

    public void createCarRacer(String inputCarNames){
        List<String> carList = parseCarNames(validateCarNames(inputCarNames));
        createCar(carList);
    }

    private String validateCarNames(String inputCarNames) {
        containsWhiteSpace(inputCarNames);
        //containsNumber(inputCarNames);
        checkNameSize(inputCarNames);
        checkSingle(inputCarNames);
        return inputCarNames;
    }

    private void containsWhiteSpace(String inputCarNames){
        boolean isContainsWhiteSpace = StringUtils.containsWhitespace(inputCarNames);
        if(isContainsWhiteSpace){
            throw new IllegalArgumentException();
        }
    }

    private void containsNumber(String inputCarNames){
        for(char c : inputCarNames.toCharArray()){
            if(Character.isDigit(c)){
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkNameSize(String inputCarNames){
        String[] carNames = inputCarNames.split(",");
        for(String carName : carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkSingle(String inputCarNames){
        String[] carNames = inputCarNames.split(",");
        if(carNames.length == 1){
            throw new IllegalArgumentException();
        }
    }

    private List<String> parseCarNames(String carNames){
        String regex = ",";
        return Arrays.asList(carNames.split(regex));
    }

    public String findFinalWinner(){
        int maxDistance = findMaxDistance();
        return participants
                .stream()
                .filter(car -> car.getDistance() >= maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int findMaxDistance(){
        return participants
                .stream()
                .map(Car::getDistance)
                .max(Integer::compare)
                .orElse(0);
    }

}
