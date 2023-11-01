package racingcar.domain.round;

public final class RoundDtoMapper {
    private RoundDtoMapper() {
    }

    public static int mapToRound(RoundDto roundDto) {
        return Integer.parseInt(roundDto.roundInput());
    }
}
