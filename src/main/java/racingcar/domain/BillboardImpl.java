package racingcar.domain;

import java.util.stream.Collectors;
import racingcar.config.GameMessage;
import racingcar.config.Message;
import racingcar.dto.RaceProgressDTO;

public class BillboardImpl implements Billboard {

    @Override
    public void displayraceprogress(RaceProgressDTO raceProgressDTO) {
        display(Message.NEW_LINE);
        String raceProgress = raceProgressDTO.nameAndDistanceMessages()
                .stream()
                .collect(Collectors.joining(Message.NEW_LINE));
        display(GameMessage.RACE_PROGRESS_PREFIX);
        display(raceProgress);
    }

    @Override
    public void displayWinners(WinnerStand winnerStand) {
        String winners = GameMessage.WINNER_STAND_PREFIX.getMessage() + winnerStand.getWinners();
        display(winners);
    }

    private void display(GameMessage gameMessage) {
        System.out.println(gameMessage.getMessage());
    }

    private void display(String message) {
        System.out.println(message);
    }
}
