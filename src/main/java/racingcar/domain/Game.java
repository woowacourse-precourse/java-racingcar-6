package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {

    private CarRacer carRace;

    public Game(){
        this.carRace = new CarRacer();
    }

    public void play(){
        inputCarNames();
        int attemptCount = inputAttemptCount();

        System.out.println();
        System.out.println(GameMessage.RESULT.message);
        for(int i = 0; i < attemptCount; i++){
            race();
        }

        String winnerMessage = GameMessage.WINNER_MESSAGE.message + findFinalWinner();
        System.out.println(winnerMessage);
    }

    private void inputCarNames(){
        System.out.println(GameMessage.INPUT_CAR_NAMES.message);
        String inputCarNames = validateCarNames(readLine());
        List<String> cars = parseCarNames(inputCarNames);
        carRace.createCar(cars);
    }

    private int inputAttemptCount() {
        System.out.println(GameMessage.INPUT_ATTEMPT_COUNT.message);
        return validateAttemptCount(readLine());
    }

    private String validateCarNames(String inputCarNames){
        boolean isContainsWhiteSpace = containsWhiteSpace(inputCarNames);
        if(isContainsWhiteSpace){
            throw new IllegalArgumentException();
        }
        return inputCarNames;
    }

    private boolean containsWhiteSpace(String inputCarNames){
        return StringUtils.containsWhitespace(inputCarNames);
    }

    private int validateAttemptCount(String stringAttemptCount){
        try{
            int attemptCount = Integer.parseInt(stringAttemptCount);
            if(attemptCount < 0){
                throw new IllegalArgumentException();
            }
            return attemptCount;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> parseCarNames(String carNames){
        String regex = ",";
        return Arrays.asList(carNames.split(regex));
    }

    private void race(){
        for(Car car : carRace.getParticipants()){
            if(isForward()){
                car.moveForwad();
            }
        }
        displayRaceStatus();
    }

    private boolean isForward(){
        int randomNumber = pickNumberInRange(1,9);
        return randomNumber > 4;
    }

    private void displayRaceStatus(){
        for(Car car : carRace.getParticipants()){
            System.out.println(car.getName() + " : " + car.showDistance());
        }
        System.out.println();
    }

    private String findFinalWinner(){
        int maxDistance = findMaxDistance();
        return carRace.getParticipants()
                .stream()
                .filter(car -> car.getDistance() >= maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int findMaxDistance(){
        return carRace.getParticipants()
                .stream()
                .map(Car::getDistance)
                .max(Integer::compare)
                .orElse(0);
    }
}
