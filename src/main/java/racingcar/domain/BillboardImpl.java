package racingcar.domain;

import racingcar.config.GameMessage;
import racingcar.config.Message;
import racingcar.dto.RaceProgressDTO;

public class BillboardImpl implements Billboard {

    @Override
    public void displayraceprogress(RaceProgressDTO raceProgressDTO) {
        display(Message.NEW_LINE);
        String raceProgress = String.join(Message.NEW_LINE, raceProgressDTO.nameAndDistanceMessages());
        display(GameMessage.RACE_PROGRESS_PREFIX.getMessage());
        display(raceProgress);
    }

    @Override
    public void displayWinners(WinnerStand winnerStand) {
        String winners = GameMessage.WINNER_STAND_PREFIX.getMessage() + winnerStand.getWinners();
        display(winners);
    }

    private void display(String message) {
        System.out.println(message);
    }
}
