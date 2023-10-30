package racingcar;

public class MoveResultDto {
    private final String playerName;
    private final int distance;

    public MoveResultDto(final String playerName, final int distance) {
        this.playerName = playerName;
        this.distance = distance;
    }

    public static MoveResultDto from(PlayerMove playerMove) {
        String playerName = playerMove.getPlayer().getPlayerName().getValue();
        int distance = playerMove.getDistance().getValue();
        return new MoveResultDto(playerName, distance);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getDistance() {
        return distance;
    }
}
