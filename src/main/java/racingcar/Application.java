package racingcar;

import racingcar.domain.Judgment;
import racingcar.domain.Player;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Player player = Player.getInstance();
        Judgment judgment = Judgment.getInstance();

        //System in 값 받기
        List<String> cars = player.inputCarName();
        int count = player.inputCount();

        //실행결과
        System.out.println("실행결과");
        judgment.executeForCount(count, cars);

        List<String> resultWinner = judgment.getResultWinner();
        System.out.println("최종 우승자 : " + String.join(", ", resultWinner));
    }
}
