package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    Cars carList;
    int tryChance;

    public Game(Cars cars) {
        this.carList = cars;
    }

    public void settingChance() {
        this.tryChance = Integer.parseInt(Console.readLine());
        carList.settingLogBoard(tryChance);
    }

    public void running() {
        int round = 1;
        while(round <= tryChance) {
            carList.play(round);
            round++;
        }

        System.out.println();
        int maxNumber = carList.findMaxScore();

        System.out.println("최종 우승자 : " + carList.findWinners(maxNumber));
    }
}
