package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {
    public List<RacingCar> makeCars() {
        return InputView.inputRacingCarNames();
    }

    public int getRaceCount() {
        return InputView.inputRaceCount();
    }

    public List<RacingCar> racingGame(List<RacingCar> cars, int raceCount) {
        List<List<RacingCar>> allRoundResult = new ArrayList<List<RacingCar>>();

        while(raceCount > 0) {
            List<RacingCar> beforeRace = null;
            if(allRoundResult.isEmpty()) {
                beforeRace = cars;
            }
            if(!allRoundResult.isEmpty()) {
                beforeRace = allRoundResult.get(allRoundResult.size()-1);
            }
            List<RacingCar> roundResult = raceRound(beforeRace);
            allRoundResult.add(roundResult);
            raceCount--;
        }

        OutputView.outputAllRoundResult(allRoundResult);
        return allRoundResult.get(allRoundResult.size()-1);
    }

    private List<RacingCar> raceRound(List<RacingCar> cars) {
        return cars.stream()
                .map(car -> car.move(Randoms.pickNumberInRange(0,9)))
                .collect(Collectors.toList());
    }

    public void calculateRacingWinner(List<RacingCar> racedCars) {
        RacingCar winner = getWinnerCar(racedCars);
        List<RacingCar> winners = racedCars.stream()
                .filter(car -> car.getMoveCount() == winner.getMoveCount())
                .collect(Collectors.toList());
        OutputView.outputWinners(winners);
    }

    private RacingCar getWinnerCar(List<RacingCar> racedCars) {
        return racedCars.stream()
                .max(Comparator.comparing(RacingCar::getMoveCount))
                .get();
    }
}
