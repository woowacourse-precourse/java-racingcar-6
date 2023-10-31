package racingcar;

import racingcar.player.Player;
import racingcar.server.Server;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Player player = new Player();
        Server server = new Server();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racerListString = player.getPlayerInput();
        server.confirmRacerList(racerListString);

        System.out.println("시도할 회수는 몇회인가요?");
        String racerCountString = player.getPlayerInput();
        server.confirmRacerCount(racerCountString);

        server.startRace();
        server.finishRace();
    }
}
