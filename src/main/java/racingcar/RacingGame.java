package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.view.View;

public class RacingGame {

    private Track track;
    private View view;
    private List<RacingCar> racingCars;
    private int raceCount;

    public RacingGame() {
        view = new View();
        ready();
    }

    private void ready() {
        List<String> carNames = acceptApplicants();
        raceCount = assignRaceCount();

        racingCars = createRacingCars(carNames);
        track = new Track();
    }

    public void race() {
        int roundNumber = 0;

        view.showRaceResultHeader();

        while (roundNumber < raceCount) {
            Map<String, Integer> roundResult = track.round(racingCars);
            view.showRoundResultView(roundResult);
            roundNumber++;
        }
    }

    public void result() {
        List<String> selectedWinners = track.selectWinners(racingCars);
        view.showWinnerView(selectedWinners);
    }

    public List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> applicants = new ArrayList<>();
        carNames.forEach((name) -> {
            applicants.add(new RacingCar(name));
        });
        return applicants;
    }

    private int assignRaceCount() {
        return view.showRaceCountView();
    }

    private List<String> acceptApplicants() {
        String carNames = view.showApplicantView();
        return List.of(carNames.split(","));
    }
}
