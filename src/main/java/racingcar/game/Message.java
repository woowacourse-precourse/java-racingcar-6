package racingcar.game;

public class Message {
    private final String requestPlayerName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String requestPlayCount = "시도할 회수는 몇회인가요?";
    private final String champion = "최종 우승자 : ";
    private final String result = "실행 결과";
    private final String spaceColon = " : ";
    private final char distanceUnit = '-';

    public String distanceOfPlayer( Player player ){
        StringBuilder message = new StringBuilder();

        message.append(player.getName()).append(spaceColon);

        for(int i = 0 ; i < player.getDistance(); i++){
            message.append(distanceUnit);
        }

        return message.toString();
    }
}
