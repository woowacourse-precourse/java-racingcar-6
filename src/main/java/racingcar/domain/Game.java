package racingcar.domain;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Game {

    private CarRace carRace;

    public Game(){
        this.carRace = new CarRace();
    }

    public void inputCarNames(){
        System.out.println(GameMessage.INPUT_CAR_NAMES.message);
        List<String> cars = parseCarNames(readLine());
        carRace.createCar(cars);
    }

    public void inputAttemptCount() {
        System.out.println(GameMessage.INPUT_ATTEMPT_COUNT.message);
        int attemptCount = validateAttemptCount(readLine());
        race(attemptCount);
    }

    public int validateAttemptCount(String stringAttemptCount){
        int attemptCount = 0;
        try{
            attemptCount = Integer.parseInt(stringAttemptCount);
            if(attemptCount < 0){
                throw new IllegalArgumentException("0 이상의 정수만 입력 가능합니다.");
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }
        return attemptCount;
    }

    public List<String> parseCarNames(String carNames){
        String regex = ",";
        return Arrays.asList(carNames.split(regex));
    }

    public void race(int attemptCount){
    }
}
