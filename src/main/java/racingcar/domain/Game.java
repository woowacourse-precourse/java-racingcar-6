package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Game {

    private CarRacer carRace;

    public Game(){
        this.carRace = new CarRacer();
    }

    public void play(){
        List<Car> participants = inputCarNames();
        int attemptCount = inputAttemptCount();
    }

    private List<Car> inputCarNames(){
        System.out.println(GameMessage.INPUT_CAR_NAMES.message);
        String inputCarNames = validateCarNames(readLine());
        List<String> cars = parseCarNames(inputCarNames);
        carRace.createCar(cars);
        return carRace.getParticipants();
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

    private void race(int attemptCount){
    
    }
}
