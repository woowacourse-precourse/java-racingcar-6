package racingcar.dto;


public record CarStatusDto(
        String name,
        Integer score
) {
    public static CarStatusDto create(String playerName, int playerScore) {
        return new CarStatusDto(playerName, playerScore);
    }
}
