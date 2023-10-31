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

    public void game(Race raceList, int raceCount) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < raceCount; i++) {
            raceList.play();
            raceList.printPlay();
        }
    }

    public void getResult(Race raceList) {
        int max = raceList.getMaxNum();
        String[] winner = raceList.getWinner(max);

        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
