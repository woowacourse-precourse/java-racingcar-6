package racingcar.dto;

import racingcar.domain.PlayerMove;

public class MoveResultDto {
    private final String playerName;
    private final int distance;

    private MoveResultDto(final String playerName, final int distance) {
        this.playerName = playerName;
        this.distance = distance;
    }


    public static MoveResultDto from(final PlayerMove playerMove) {
        String playerName = playerMove.getPlayerRawName();
        int distance = playerMove.getRawDistance();
        return new MoveResultDto(playerName, distance);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getDistance() {
        return distance;
    }
}
