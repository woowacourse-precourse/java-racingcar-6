package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import racingcar.domain.Judgement;
import racingcar.domain.Racingprocess;
import racingcar.domain.Userconsole;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Judgement referee = new Judgement();
        Userconsole ask = new Userconsole();
        Racingprocess race = new Racingprocess();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> cars = ask.makingCarList();

        System.out.println("시도할 횟수는 몇회인가요?");
        int rounds = ask.askRounds();

        System.out.println("\n실행 결과");
        ArrayList<Integer> progress = new ArrayList<>(Collections.nCopies(cars.size(), 0));
        race.doRace(rounds, cars, progress);

        String winner = referee.whoisWinner(cars, progress);
        System.out.println("최종 우승자 : " + winner);
    }
}
