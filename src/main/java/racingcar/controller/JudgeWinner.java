package racingcar.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Judges the winner of race game
 *
 * @author WorldBestProgrammer
 */
public class JudgeWinner {

    /**
     * Returns the name of winners
     *
     * @param userCarDistance The key is car name and the value is distance at end of race
     * @return The list of the winners' name
     */
    public static List<String> judgeWinner(Map<String, Integer> userCarDistance) {

        Integer maxValue = Collections.max(userCarDistance.values());

        return userCarDistance.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), maxValue))
                .map(Map.Entry::getKey)
                .toList();
    }
}
