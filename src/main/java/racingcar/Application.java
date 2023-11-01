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

        ArrayList<String> cars = ask.makingCarList();
        int rounds = ask.askRounds();

        System.out.println("\n실행 결과");
        ArrayList<Integer> progress = new ArrayList<>(Collections.nCopies(cars.size(), 0));

        race.doRace(rounds, cars, progress);

        referee.whoisWinner(cars, progress);
    }
}
