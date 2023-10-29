package racingcar.model;

import java.util.ArrayList;

public class CarRacingGame {
    private ArrayList<RacingCar> ParticipationConfirmedCarList = new ArrayList<>();
    private int raceCount;
    private ArrayList<RacingCar> winners = new ArrayList<>();

    public CarRacingGame(ArrayList<RacingCar> racingCars) {
        this.ParticipationConfirmedCarList = racingCars;
    }

    public int getRaceCount() {
        return this.raceCount;
    }

    public void setRaceCount(int raceCount) {
        this.raceCount = raceCount;
    }

    public void insertIntoWinners (RacingCar racingCar) {
        this.winners.add(racingCar);
    }

    public ArrayList<RacingCar> getParticipationConfirmedCarList() {
        return this.ParticipationConfirmedCarList;
    }

    public ArrayList<RacingCar> getWinners() {
        return this.winners;
    }
}


