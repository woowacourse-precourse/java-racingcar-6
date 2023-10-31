package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        CarRace carRace = new CarRace();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] contestants = carRace.contestantSignup(input);

        System.out.println("시도할 회수는 몇회인가요?");
        int round = Integer.parseInt(Console.readLine());

        int[] move = new int[contestants.length];
        Arrays.fill(move, 0);

        System.out.println("\n실행 결과");
        for (int j = 0; j < round; j++) {
            for (int i = 0; i < contestants.length; i++) {
                move[i] = carRace.showCurrentRound(contestants[i], move[i]); // 반환된 값을 move에 저장
            }
            System.out.println();
        }
        carRace.printWinners(carRace.whoseWinner(contestants, move));
    }
}
