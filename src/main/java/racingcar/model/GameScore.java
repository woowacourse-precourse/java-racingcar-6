package racingcar.model;

import racingcar.constant.CarStatus;
import racingcar.constant.ExceptionResponse;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class GameScore {
    private final static String DELIMITER =  " : ";
    private final Map<RacingCar, String> participants;

    private GameScore(Map<RacingCar, String> participants) {
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

    public static GameScore createByRacingCars(List<RacingCar> racingCars){
        validateDuplicate(racingCars);
        Map<RacingCar, String> gameScore = new LinkedHashMap<>();
        for (RacingCar racingCar : racingCars) {
            gameScore.put(racingCar, CarStatus.STOP.getOutput());
        }
        return new GameScore(gameScore);
    }

    public void update(RacingCar racingCar, Supplier<Integer> supplier) {
        participants.replace(racingCar, participants.get(racingCar)
                + racingCar.apply(supplier.get()).getOutput());
    }

    public List<RacingCar> getWinner() {
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
        String gameScore = new String();
        for(Map.Entry<RacingCar, String> entry :participants.entrySet()){
            gameScore += entry.getKey() + DELIMITER + entry.getValue();
            gameScore += System.lineSeparator();
        }
        return gameScore;
    }


}
