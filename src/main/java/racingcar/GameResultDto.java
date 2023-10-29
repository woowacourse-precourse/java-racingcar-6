package racingcar;

public class GameResultDto {
    private final String playerName;
    private final int distance;

    public GameResultDto(String playerName, int distance) {
        this.playerName = playerName;
        this.distance = distance;
    }

    public static GameResultDto from(PlayerMove playerMove) {
        String playerName = playerMove.getPlayer().getPlayerName().getValue();
        int distance = playerMove.getDistance().getValue();
        return new GameResultDto(playerName, distance);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getDistance() {
        return distance;
    }
}
