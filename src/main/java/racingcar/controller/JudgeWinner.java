package racingcar.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class JudgeWinner {
    public static List<String> judgeWinner(Map<String, Integer> userCarDistance) {

        Integer maxValue = Collections.max(userCarDistance.values());

        return userCarDistance.entrySet().stream()
            .filter(entry -> Objects.equals(entry.getValue(), maxValue))
            .map(Map.Entry::getKey)
            .toList();
    }
}
