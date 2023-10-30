package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.MidGameResultDto;
import racingcar.model.CarRacingGame;
import racingcar.model.RacingCar;
import racingcar.validation.ValidateInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGameService {
    private static final int DEFAULT_DISTANCE = 0;
    private CarRacingGame carRacingGame;
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

    public CarRacingGame createRacingGame(String userEnteredApplicantCarList, int raceCount) {
        ArrayList<RacingCar> ParticipationConfirmedCarList = makeParticipationConfirmedCarList(userEnteredApplicantCarList);
        carRacingGame = new CarRacingGame(ParticipationConfirmedCarList);
        carRacingGame.setRaceCount(raceCount);
        System.out.println();
        return carRacingGame;
    }

    private ArrayList<RacingCar> makeParticipationConfirmedCarList(String userEnteredApplicantCarList) {
        return (ArrayList<RacingCar>) Arrays.stream(userEnteredApplicantCarList.split(","))
                .map(carName -> new RacingCar(carName.trim(), DEFAULT_DISTANCE))
                .collect(Collectors.toList());
    }

    public ArrayList<MidGameResultDto> gameInProcess() {
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

    private ArrayList<MidGameResultDto> midResultAnnouncement() {
        ArrayList<RacingCar> participationConfirmedCarList = carRacingGame.getParticipationConfirmedCarList();
        ArrayList<MidGameResultDto> midGameResultDtoList = new ArrayList<>();

        for (RacingCar racingCar : participationConfirmedCarList) {
            MidGameResultDto midGameResultDto = new MidGameResultDto(racingCar.getName(), racingCar.getDistance());
            midGameResultDtoList.add(midGameResultDto);
        }
        return midGameResultDtoList;
    }

    public ArrayList<RacingCar> findWinnerByMaxDistance() {
        ArrayList<RacingCar> participationConfirmedCarList = carRacingGame.getParticipationConfirmedCarList();
        int maxDistance = findMaxDistance(participationConfirmedCarList);
        return findWinnerName(participationConfirmedCarList, maxDistance);
    }

    private int findMaxDistance(ArrayList<RacingCar> participationConfirmedCarList) {
        int[] distanceSortArray = new int[participationConfirmedCarList.size()];

        int i = 0;
        for (RacingCar racingCar : participationConfirmedCarList) {
            distanceSortArray[i] = racingCar.getDistance();
            i ++;
        }
        return Arrays.stream(distanceSortArray).max().getAsInt();
    }

    private ArrayList<RacingCar> findWinnerName(ArrayList<RacingCar> participationConfirmedCarList, int maxDistance) {
        for (RacingCar racingCar : participationConfirmedCarList) {
            if (racingCar.getDistance() == maxDistance) {
                carRacingGame.insertIntoWinners(racingCar);
            }
        }
        return carRacingGame.getWinners();
    }
}
