package racingcar.view.output;

import racingcar.model.Cars;
import racingcar.repository.Track;

public class OutputView {
    public static void printTrack(Track track) {
        System.out.println("실행 결과");
        System.out.println(track);
    }

    public static void printWinner(Cars cars) {
        System.out.println("최종 우승자 : " + cars);
    }
}
