package racingcar.View.output;

import racingcar.dto.MidGameResultDto;
import racingcar.model.RacingCar;

import java.util.ArrayList;

public class OutPutView {
    OutputFormatter outputFormatter = new OutputFormatter();

    public void resultAnnouncementMessage() {
        System.out.println("실행 결과");
    }

    public void midGameResultMessage(ArrayList<MidGameResultDto> midGameResultDtoList) {
        for (MidGameResultDto midGameResultDto : midGameResultDtoList) {
            System.out.println(outputFormatter.midGameResultMessage(midGameResultDto));
        }
    }

    public void FinalWinnerAnnouncementMessage(ArrayList<RacingCar> winnerList) {
        System.out.println(outputFormatter.winnerAnnouncementMessage(winnerList));
    }
}