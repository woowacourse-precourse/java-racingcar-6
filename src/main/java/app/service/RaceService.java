package app.service;

import app.domain.Race;
import app.repository.RaceRepository;

import java.util.Comparator;
import java.util.Map;

public class RaceService {

    private final RaceRepository raceRepository = new RaceRepository();

    public Race getCarName() {
        String carName = raceRepository.getCarName();
        return new Race(carName);
    }

    public int getRaceCount() {
        String raceCount = raceRepository.getRaceCount();
        return Integer.parseInt(raceCount);
    }

}
