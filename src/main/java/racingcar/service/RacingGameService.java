package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.GameResultDto;
import racingcar.model.CarRacingGame;
import racingcar.model.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGameService {
    private static final int DEFAULT_DISTANCE = 0;
    private CarRacingGame carRacingGame;

    public void settingForRacingGame(String userEnteredApplicantCarList, int raceCount) {
        ArrayList<RacingCar> ParticipationConfirmedCarList = makeParticipationConfirmedCarList(userEnteredApplicantCarList);
        carRacingGame = new CarRacingGame(ParticipationConfirmedCarList);
        carRacingGame.setRaceCount(raceCount);
        System.out.println();
    }

    private ArrayList<RacingCar> makeParticipationConfirmedCarList(String userEnteredApplicantCarList) {
        return (ArrayList<RacingCar>) Arrays.stream(userEnteredApplicantCarList.split(","))
                .map(carName -> new RacingCar(carName.trim(), DEFAULT_DISTANCE))
                .collect(Collectors.toList());
    }

    public ArrayList<GameResultDto> gameInProcess() {
        ArrayList<RacingCar> participationConfirmedCarList = carRacingGame.getParticipationConfirmedCarList();
        racingCarMove(participationConfirmedCarList);
        return midResultAnnouncement();
    }

    public void racingCarMove(ArrayList<RacingCar> participationConfirmedCarList) {
        for (RacingCar racingCar : participationConfirmedCarList) {
            int randomNumberToMove = Randoms.pickNumberInRange(0, 9);
            if (randomNumberToMove >= 4) {
                racingCar.addDistance();
            }
        }
    }

    public ArrayList<GameResultDto> midResultAnnouncement() {
        ArrayList<RacingCar> participationConfirmedCarList = carRacingGame.getParticipationConfirmedCarList();
        ArrayList<GameResultDto> gameResultDtoList = new ArrayList<>();

        for (RacingCar racingCar : participationConfirmedCarList) {
            GameResultDto gameResultDto = new GameResultDto(racingCar.getName(), racingCar.getDistance());
            gameResultDtoList.add(gameResultDto);
        }
        return gameResultDtoList;
    }
}
