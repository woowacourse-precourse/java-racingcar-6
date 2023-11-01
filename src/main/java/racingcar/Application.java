package racingcar;

import racingcar.domain.Game;
import racingcar.domain.PlayerInput;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayerInput player = new PlayerInput();
        Map<String, Integer> racers = player.nameInput();
        int time = player.playTimeInput();
        Game game = new Game();
        System.out.println("\n실행결과");
        for (int i = 0; i < time; i++) {
            game.printResult(racers);
        }
        System.out.print("최종 우승자 : " + String.join(", ", game.printWinner(racers)));
//        System.out.println(racers);
    }
}


