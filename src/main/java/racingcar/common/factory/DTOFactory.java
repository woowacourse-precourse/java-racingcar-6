package racingcar.common.factory;

import java.util.List;
import racingcar.dto.output.RoundDTO;
import racingcar.dto.output.WinnerDTO;

public class DTOFactory {
    public static RoundDTO createRoundDTO(String name, int distance) {
        return new RoundDTO(name, distance);
    }

    public static WinnerDTO createWinnerDTO(List<String> winnerNames) {
        return new WinnerDTO(winnerNames);
    }
}
