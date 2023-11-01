package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import racingcar.dto.CarDto;

public class RaceResultGenerator {

    public List<String> checkWinner(LinkedHashSet<CarDto> carDtos) {
        List<String> winners = new ArrayList<>();
        LinkedHashMap<String, Integer> raceStatus = generateRaceStatus(carDtos);
        int max = Collections.max(raceStatus.values());

        for(Map.Entry<String, Integer> entry : raceStatus.entrySet()) {
            if(entry.getValue() == max) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }

    private LinkedHashMap<String, Integer> generateRaceStatus(LinkedHashSet<CarDto> carDtos) {
        LinkedHashMap<String, Integer> raceResult = new LinkedHashMap<>();

        for (CarDto carDto : carDtos) {
            raceResult.put(carDto.name(), carDto.moved());
        }
        return raceResult;
    }
}