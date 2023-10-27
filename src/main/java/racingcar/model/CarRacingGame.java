package racingcar.model;

import java.util.ArrayList;

public class CarRacingGame {
    private ArrayList<RacingCar> ParticipationConfirmedCarList = new ArrayList<>();

    private ArrayList<RacingCar> winners = new ArrayList<>();

    public CarRacingGame(ArrayList<RacingCar> racingCars) {
        this.ParticipationConfirmedCarList = racingCars;
    }

    public void insertIntoWinners (RacingCar racingCar) {
        this.winners.add(racingCar);
    }

    public ArrayList<RacingCar> getApplicantRacingCarList() {
        return this.ParticipationConfirmedCarList;
    }

    public ArrayList<RacingCar> getWinners() {
        return this.winners;
    }
}


