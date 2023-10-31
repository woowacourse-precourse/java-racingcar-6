package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Game extends Player {
    public static void playGame(List<RacingCar> player, int numberTrials) {
        for (int i = 0; i < numberTrials; i++) {
            movingOrStop(player);
            printMiddleResult(player);
        }
        printWinner(player);
    }

    private static void movingOrStop(List<RacingCar> player) {
        for (int i = 0; i < player.size(); i++) {
            int movingOrNot = Randoms.pickNumberInRange(0, 9);
            if (movingOrNot > 3) {
                move(player, i);
            }
        }
    }

    private static void move(List<RacingCar> player, int index) {
        RacingCar racingCar = new RacingCar();
        racingCar.name = player.get(index).name;
        racingCar.distance = player.get(index).distance + 1;
        player.set(index, racingCar);
    }

    private static void printMiddleResult(List<RacingCar> player) {
        System.out.println("실행 결과");
        for (int i = 0; i < player.size(); i++) {
            System.out.print(player.get(i).name + " : ");
            printDistance(player.get(i).distance);
        }
        System.out.println();
    }

    private static void printDistance(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void printWinner(List<RacingCar> player) {
        int maxDistance = getMaxDistance(player);
        String winner = getWinner(player, maxDistance);

        System.out.println("최종 우승자 : " + winner);
    }

    private static int getMaxDistance(List<RacingCar> player) {
        int maxDistance = 0;
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).distance > maxDistance) {
                maxDistance = player.get(i).distance;
            }
        }

        return maxDistance;
    }

    private static String getWinner(List<RacingCar> player, int maxDistance) {
        String winner = "";
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).distance == maxDistance) {
                winner = winner.concat(player.get(i).name + ", ");
            }
        }
        return winner.substring(0, winner.length() - 2);
    }
}
