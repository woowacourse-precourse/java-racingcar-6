package racingcar.view;

import static racingcar.constant.Constant.COLON;
import static racingcar.constant.Constant.ENTER;
import static racingcar.constant.Constant.MINUS_SIGN;

import java.util.List;
import racingcar.dto.RacingCarDto;

public class ViewResolver {

    public String singleGameResult(List<RacingCarDto> singleGameResult) {
        StringBuilder resolvedGameResult = new StringBuilder();
        singleGameResult.forEach(result -> {
            resolvedGameResult.append(result.getCarName()).append(COLON);
            resolvedGameResult.append(MINUS_SIGN.repeat(Math.max(0, result.getPosition()))).append(ENTER);
        });
        return resolvedGameResult.toString();
    }

    public List<String> winners(List<RacingCarDto> racingCarDtos) {
        return createWinnerNames(getWinnerDtos(racingCarDtos));
    }

    private List<String> createWinnerNames(List<RacingCarDto> racingCarDtos) {
        return racingCarDtos.stream().map(RacingCarDto::getCarName).toList();
    }

    private List<RacingCarDto> getWinnerDtos(List<RacingCarDto> racingCarDtos) {
        int finishLine = findFinishLine(racingCarDtos);
        return findWinnerDtos(racingCarDtos, finishLine);
    }

    private int findFinishLine(List<RacingCarDto> racingCarDtos) {
        int finishLine = 0;
        for (RacingCarDto racingCarDto : racingCarDtos) {
            finishLine = Math.max(racingCarDto.getPosition(), finishLine);
        }
        return finishLine;
    }

    private static List<RacingCarDto> findWinnerDtos(List<RacingCarDto> racingCarDtos, int finishLine) {
        return racingCarDtos.stream().filter(racingCarDto -> racingCarDto.getPosition() == finishLine).toList();
    }
}
