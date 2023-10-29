package racingcar.View;

import racingcar.dto.GameResultDto;
import racingcar.model.RacingCar;

import java.util.ArrayList;

public class OutPutView {

    public void resultAnnouncementMessage() {
        System.out.println("실행 결과");
    }
    public void midGameResultMessage(ArrayList<GameResultDto> midGameResultDtoList) {
        midResultOutPutMessage(midGameResultDtoList);
    }

    public void midResultOutPutMessage(ArrayList<GameResultDto> midGameResultDtoList) {
        for (GameResultDto gameResultDto : midGameResultDtoList) {
            System.out.print(gameResultDto.getRacingCarName() + " : ");
            System.out.println(distanceVisualization(gameResultDto.getDistance()));
        }
    }

    private String distanceVisualization(int distance) {
        StringBuilder distanceVisualizationBuilder = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            distanceVisualizationBuilder.append("-");
        }

        return distanceVisualizationBuilder.toString();
    }
}