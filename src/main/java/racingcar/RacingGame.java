package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.view.View;

public class RacingGame {

    private Track track;
    private View view;
    private int raceCount;

    public RacingGame() {
        view = new View();
        ready();
    }

    public void race() {
        view.showRaceResultHeader();
        for (int roundNumber = 0; roundNumber < raceCount; roundNumber++) {
            Map<String, Integer> roundResult = track.round(roundNumber);
            view.showRoundResultView(roundResult);
        }
        result();
    }

    private void result() {
        List<String> selectedWinners = track.selectWinners();
        view.showWinnerView(selectedWinners);
    }

    private void ready() {
        List<String> carNames = acceptApplicants();
        raceCount = assignRaceCount();

        List<RacingCar> racingCars = createRacingCars(carNames);
        track = new Track(racingCars);
    }

    public List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> applicants = new ArrayList<>();
        carNames.forEach((name) -> {
            applicants.add(new RacingCar(name));
        });
        return applicants;
    }

    public int assignRaceCount() {
        return view.showRaceCountView();
    }

    private List<String> acceptApplicants() {
        String carNames = view.showApplicantView();
        return List.of(carNames.split(","));
    }
}
