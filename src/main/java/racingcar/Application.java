package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Race race = new Race();

        // 입력 받기
        // 경주할 자동차 이름
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        race.setCars(Console.readLine());

        // 횟수
        System.out.println("시도할 회수는 몇회인가요?");
        race.setRound(Integer.parseInt(Console.readLine()));

        // racing
        for (int i=0; i<race.getRound(); i++){
            race.go();
            race.printRound();
        }

        // 최종우승자 계산
        // 최종우승자 출력
        // 단독우승일 경우, 공동우승일 경우 나눠서 출력

    }

}
