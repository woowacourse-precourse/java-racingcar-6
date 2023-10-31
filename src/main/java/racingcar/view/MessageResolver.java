package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatusDto;
import racingcar.dto.RoundResultDto;

public class MessageResolver {

    public String resolveWinnerMessage(List<CarStatusDto> winners) {
        String winnerNames = winners.stream()
                .map(carStatusDto -> carStatusDto.getCarName().getValue())
                .collect(Collectors.joining(","));
        return "최종 우승자 : " + winnerNames;
    }

    public String resolveRoundResultMessage(RoundResultDto roundResultDto) {
        List<CarStatusDto> carStatusDtos = roundResultDto.getRoundResult();
        return carStatusDtos.stream()
                .map(dto -> dto.getCarName().getValue() + " : " + dto.getCarPosition().draw())
                .collect(Collectors.joining("\n")) + "\n";
    }
}
