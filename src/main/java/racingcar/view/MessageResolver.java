package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatusDto;
import racingcar.dto.RoundResultDto;

public class MessageResolver {

    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    public static final String SEPARATOR = " : ";

    public String resolveWinnerMessage(List<CarStatusDto> winners) {
        String winnerNames = winners.stream()
                .map(carStatusDto -> carStatusDto.getCarName().getValue())
                .collect(Collectors.joining(","));
        return WINNER_MESSAGE_PREFIX + winnerNames;
    }

    public String resolveRoundResultMessage(RoundResultDto roundResultDto) {
        List<CarStatusDto> carStatusDtos = roundResultDto.getRoundResult();
        return carStatusDtos.stream()
                .map(dto -> dto.getCarName().getValue() + SEPARATOR + dto.getCarPosition().draw())
                .collect(Collectors.joining("\n")) + "\n";
    }
}
