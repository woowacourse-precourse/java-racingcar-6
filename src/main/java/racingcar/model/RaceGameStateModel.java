package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Stores the states of race game
 * <p>
 * This class has totalRound and userCarDistance which has (car name, distance) pair
 * @author WorldBestProgrammer
 */
public class RaceGameStateModel {

    private final int totalRound;
    private LinkedHashMap<String, Integer> userCarDistance;

    /**
     * Initializes totalRound and userCarDistance
     *
     * @param totalRound Total number of round
     * @param userCars List of car names
     */
    public RaceGameStateModel(int totalRound, List<String> userCars) {
        this.totalRound = totalRound;
        initializeUserCarDistance(userCars);
    }

    /**
     * Initializes userCarDistance
     *
     * @param userCars List of car names
     */
    public void initializeUserCarDistance(List<String> userCars) {
        this.userCarDistance = new LinkedHashMap<>();
        for (String userCar : userCars) {
            userCarDistance.put(userCar, 0);
        }
    }

    /**
     * Gets total round
     *
     * @return Total round
     */
    public int getTotalRound() {
        return totalRound;
    }

    /**
     * Gets userCarDistance
     *
     * @return userCarDistance
     */
    public LinkedHashMap<String, Integer> getUserCarDistance() {
        return userCarDistance;
    }

    /**
     * Gets distance of userCarDistance with key
     *
     * @param key Car name
     * @return Distance of car name
     */
    public Integer getUserCarDistance(String key) {
        return userCarDistance.get(key);
    }

    /**
     * Updates distance of car
     *
     * @param key Car name
     * @param newValue New distance value of car name
     */
    public void updateUserDistance(String key, int newValue) {
        this.userCarDistance.put(key, newValue);
    }
}
