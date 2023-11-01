package racingcar.model;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<RacingCar> ParticipationConfirmedCarList;
    private int raceCount;
    private ArrayList<RacingCar> winnerList = new ArrayList<>();

    public RacingGame(ArrayList<RacingCar> racingCars) {
        this.ParticipationConfirmedCarList = racingCars;
    }

    public int getRaceCount() {
        return this.raceCount;
    }

    public void setRaceCount(int raceCount) {
        this.raceCount = raceCount;
    }

    public void addWinnerList (RacingCar racingCar) {
        this.winnerList.add(racingCar);
    }

    public ArrayList<RacingCar> getParticipationConfirmedCarList() {
        return this.ParticipationConfirmedCarList;
    }

    public ArrayList<RacingCar> getWinnerList() {
        return this.winnerList;
    }
}


