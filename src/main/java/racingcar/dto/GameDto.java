package racingcar.dto;


public class GameDto {
    private Long gameId;

    private Integer playCount;

    public GameDto(Long gameId, Integer playCount) {
        this.gameId = gameId;
        this.playCount = playCount;
    }

    public Long getGameId() {
        return gameId;
    }

    public Integer getPlayCount() {
        return playCount;
    }
}
