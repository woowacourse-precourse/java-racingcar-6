package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.MidGameResultDto;
import racingcar.model.RacingGame;
import racingcar.model.RacingCar;
import racingcar.validation.ValidateInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {
    private static final int DEFAULT_DISTANCE = 0;
    private RacingGame racingGame;
    ValidateInput validateInput = new ValidateInput();

    public void validateUserInputApplicant(String userEnteredApplicantCarList) {
        validateCarNameLengthUnderFive(userEnteredApplicantCarList);
        validateInput.validateInPutApplicantCarList(userEnteredApplicantCarList);
    }

    private void validateCarNameLengthUnderFive(String userEnteredApplicantCarList) {
        String[] ApplicantCarNameList = userEnteredApplicantCarList.split(",");
        for (String carName : ApplicantCarNameList) {
            validateInput.validateInputCarNameLength(carName);
        }
    }

    public void validateUserInputRaceCount(int userEnteredRaceCount) {
        validateInput.validateInputRaceCount(userEnteredRaceCount);
    }

    public RacingGame createRacingGame(String userEnteredApplicantCarList, int raceCount) {
        ArrayList<RacingCar> ParticipationConfirmedCarList = makeParticipationConfirmedCarList(userEnteredApplicantCarList);
        racingGame = new RacingGame(ParticipationConfirmedCarList);
        racingGame.setRaceCount(raceCount);
        System.out.println();
        return racingGame;
    }

    private ArrayList<RacingCar> makeParticipationConfirmedCarList(String userEnteredApplicantCarList) {
        return (ArrayList<RacingCar>) Arrays.stream(userEnteredApplicantCarList.split(","))
                .map(carName -> new RacingCar(carName.trim(), DEFAULT_DISTANCE))
                .collect(Collectors.toList());
    }

    public ArrayList<MidGameResultDto> gameInProcess() {
        ArrayList<RacingCar> participationConfirmedCarList = racingGame.getParticipationConfirmedCarList();
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

    private ArrayList<MidGameResultDto> midResultAnnouncement() {
        ArrayList<RacingCar> participationConfirmedCarList = racingGame.getParticipationConfirmedCarList();
        ArrayList<MidGameResultDto> midGameResultDtoList = new ArrayList<>();

        for (RacingCar racingCar : participationConfirmedCarList) {
            MidGameResultDto midGameResultDto = new MidGameResultDto(racingCar.getName(), racingCar.getDistance());
            midGameResultDtoList.add(midGameResultDto);
        }
        return midGameResultDtoList;
    }

    public ArrayList<RacingCar> findWinnerByMaxDistance() {
        ArrayList<RacingCar> participationConfirmedCarList = racingGame.getParticipationConfirmedCarList();
        int maxDistance = findMaxDistance(participationConfirmedCarList);
        return findWinnerName(participationConfirmedCarList, maxDistance);
    }

    private int findMaxDistance(ArrayList<RacingCar> participationConfirmedCarList) {
        List<Integer> distanceList = participationConfirmedCarList.stream()
                .map(RacingCar::getDistance)
                .toList();

        return distanceList.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    private ArrayList<RacingCar> findWinnerName(ArrayList<RacingCar> participationConfirmedCarList, int maxDistance) {
        for (RacingCar racingCar : participationConfirmedCarList) {
            if (racingCar.getDistance() == maxDistance) {
                racingGame.addWinnerList(racingCar);
            }
        }
        return racingGame.getWinnerList();
    }
}
