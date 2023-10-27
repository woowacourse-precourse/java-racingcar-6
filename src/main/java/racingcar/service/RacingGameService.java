package racingcar.service;

import racingcar.View.InputView;
import racingcar.model.CarRacingGame;
import racingcar.model.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {
    private static final int DEFAULT_DISTANCE = 0;

    public void settingForRacingGame(String userEnteredApplicantCarList, int raceCount) {
        ArrayList<RacingCar> ParticipationConfirmedCarList = makeParticipationConfirmedCarList(userEnteredApplicantCarList);
        CarRacingGame carRacingGame = new CarRacingGame(ParticipationConfirmedCarList);
        carRacingGame.setRaceCount(raceCount);
    }

    private ArrayList<RacingCar> makeParticipationConfirmedCarList(String userEnteredApplicantCarList) {
        return (ArrayList<RacingCar>) Arrays.stream(userEnteredApplicantCarList.split(","))
                .map(carName -> new RacingCar(carName.trim(), DEFAULT_DISTANCE))
                .collect(Collectors.toList());
    }


}
