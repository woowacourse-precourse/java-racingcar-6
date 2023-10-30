package racingcar.dto;


public class GameDto {
    private Long gameId;

    private Integer playCount;

    public GameDto(Long gameId, Integer playCount) {
        this.gameId = gameId;
        this.playCount = playCount;
    }
}
