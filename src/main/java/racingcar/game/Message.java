package racingcar.game;

import java.util.List;

public class Message {
    public final String requestPlayerName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final String requestPlayCount = "시도할 회수는 몇회인가요?";
    public final String result = "실행 결과";
    private final String champion = "최종 우승자 : ";
    private final String spaceColon = " : ";
    private final String comma = ", ";
    private final char distanceUnit = '-';

    public String distanceOfPlayer(Player player) {
        StringBuilder message = new StringBuilder();

        message.append(player.getName()).append(spaceColon);

        for (int i = 0; i < player.getDistance(); i++) {
            message.append(distanceUnit);
        }

        return message.toString();
    }

    public String champions(List<Player> champions) {
        StringBuilder message = new StringBuilder();
        message.append(champion);

        for (int i = 0; i < champions.size(); i++) {
            message.append(champions.get(i).getName());
            if (i < champions.size() - 1) {
                message.append(comma);
            }
        }

        return message.toString();
    }
}
