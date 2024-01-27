package racingcar;

import camp.nextstep.edu.missionutils.Console;
import game.BeforeGame;
import game.Gaming;
import java.util.*;

public class Application {

    Map<String, Integer> carsMap = null;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {

            // 차 이름 입력받기
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            Map<String, Integer> carsMap = BeforeGame.enterTheCarsName(Console.readLine());

            Gaming gaming = new Gaming(carsMap);

            // 시도 횟수 입력받기
            System.out.println("시도할 회수는 몇회인가요?");
            int tryNum = Integer.parseInt(Console.readLine());

            // 게임 시작하기
            System.out.println("\n실행 결과");
            gaming.playGame(tryNum);

            // 최종 우승자 출력
            gaming.printFinalWinner();
            System.out.println();

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

}
