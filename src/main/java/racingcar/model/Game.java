package racingcar.model;

import racingcar.constant.CarStatus;
import racingcar.constant.ExceptionResponse;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Game {
    private final static String DELIMITER =  " : ";
    private final Map<RacingCar, String> participants;

    private Game(Map<RacingCar, String> participants) {
        this.participants = participants;
    }

    private static void validateDuplicate(List<RacingCar> racingCars){
        long nonDuplicateSize = racingCars.stream()
                .distinct()
                .count();
        if (nonDuplicateSize != racingCars.size()) {
            throw new IllegalArgumentException(ExceptionResponse.DUPLICATE_RACING_CAR.getMessage());
        }
    }

    public static Game createByRacingCars(List<RacingCar> racingCars){
        validateDuplicate(racingCars);
        Map<RacingCar, String> gameStatus = new LinkedHashMap<>();
        for (RacingCar racingCar : racingCars) {
            gameStatus.put(racingCar, CarStatus.STOP.getOutput());
        }
        return new Game(gameStatus);
    }

    public void updateStatus(RacingCar racingCar, Supplier<Integer> moveCondition) {
        participants.replace(racingCar, participants.get(racingCar)
                + racingCar.decideMove(moveCondition.get()).getOutput());
    }

    public List<RacingCar> findWinners() {
        String winnerScore = participants.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .max(Comparator.comparing(String::length)).get();
        return participants.entrySet()
                .stream()
                .filter(entry -> winnerScore.length() == entry.getValue().length())
                .map(Map.Entry::getKey)
                .toList();
    }

    @Override
    public String toString() {
        String gameStatus = new String();
        for(Map.Entry<RacingCar, String> entry :participants.entrySet()){
            gameStatus += entry.getKey() + DELIMITER + entry.getValue();
            gameStatus += System.lineSeparator();
        }
        return gameStatus;
    }


}
