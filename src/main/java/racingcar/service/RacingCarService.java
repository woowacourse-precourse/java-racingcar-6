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
        List<RacingCar> racedCars = cars;
        System.out.println("\n실행 결과");
        while(raceCount > 0) {
            racedCars = raceRound(racedCars);
            raceCount--;
        }
        return racedCars;
    }

    private List<RacingCar> raceRound(List<RacingCar> cars) {
        List<RacingCar> racedRoundCars = cars.stream()
                .map(car -> car.move(Randoms.pickNumberInRange(0,9)))
                .collect(Collectors.toList());

        OutputView.outputRaceRoundResult(racedRoundCars);
        return racedRoundCars;
    }

    public void calculateRacingWinner(List<RacingCar> racedCars) {
//        List<String> winners = racedCars.stream()
//                .max(Comparator.comparing(RacingCar::getMoveCount))
//                .map(winnerCar -> winnerCar.getName())
//                .stream().toList();
        RacingCar winner = racedCars.stream()
                .max(Comparator.comparing(RacingCar::getMoveCount))
                .get();
        List<String> winners = racedCars.stream()
                .filter(car -> car.getMoveCount() == winner.getMoveCount())
                .map(car -> car.getName())
                .collect(Collectors.toList());
        OutputView.outputWinners(winners);
    }
}
