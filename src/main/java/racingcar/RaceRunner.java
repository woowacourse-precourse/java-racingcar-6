package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class RaceRunner {
    private final Race race;

    public RaceRunner() {
        this.race = Race.initializeRaceInformation();
    }

    public void playGame() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < race.getTryNumber(); i++) {
            for (int carIndex = 0; carIndex < race.getCarsLength(); carIndex++) {
                giveScore(carIndex);
            }
            printEachRace();
        }
        printFinalResult(race.findFinalWinner());
    }

    private void giveScore(int carIndex) {
        int randomNum = makeRandomNum();
        if (randomNum >= 4) {
            race.increaseChanceScore(carIndex);
        }
    }


    public void printFinalResult(List<String> winners) {
        System.out.print("최종 우승자 :");
        for (int winner = 0; winner < winners.size(); winner++) {
            if (winner == 0) {
                System.out.print(" " + winners.get(winner));
                continue;
            }
            System.out.print(", " + winners.get(winner));
        }
    }

    private void printEachRace() {
        for (int carIndex = 0; carIndex < race.getCarsLength(); carIndex++) {
            System.out.print(race.getCar(carIndex) + " : ");
            printEachCarScore(carIndex);
            System.out.println();
        }
        System.out.println();
    }

    private int makeRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void printEachCarScore(int index) {
        int substitutionNum = race.getRaceAccumulation(index);
        for (int printNum = 0; printNum < substitutionNum; printNum++) {
            System.out.print("-");
        }
    }
}
