package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {

    private CarRacer carRacer;

    public Game(){
        this.carRacer = new CarRacer();
    }

    public void play(){
        displayInputCarNames();
        carRacer.createCarRacer(readLine());

        displayInputAttemptCount();
        int attemptCount = inputAttemptCount();
        displayRaceStatus(attemptCount);

        displayFinalWinner();
    }

    private int inputAttemptCount() {
        return validateAttemptCount(readLine());
    }

    public int validateAttemptCount(String stringAttemptCount){
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

    private void race(){
        for(Car car : carRacer.getParticipants()){
            if(isForward()){
                car.moveForward();
            }
        }
        displayRaceStatus();
    }

    private boolean isForward(){
        int randomNumber = pickNumberInRange(1, 9);
        return randomNumber >= 4;
    }

    private void displayInputCarNames(){
        System.out.println(GameMessage.INPUT_CAR_NAMES.message);
    }

    private void displayInputAttemptCount() {
        System.out.println(GameMessage.INPUT_ATTEMPT_COUNT.message);
    }

    private void displayRaceStatus(){
        for(Car car : carRacer.getParticipants()){
            System.out.println(String.format("%s : %s", car.getName(), car.showDistance()));
        }
        System.out.println();
    }

    private void displayRaceStatus(int attemptCount){
        System.out.println();
        System.out.println(GameMessage.RESULT.message);
        for (int i = 0; i < attemptCount; i++) {
            race();
        }
    }

    private void displayFinalWinner(){
        System.out.println(String.format("%s%s", GameMessage.WINNER_MESSAGE.message, carRacer.findFinalWinner()));
    }

}
