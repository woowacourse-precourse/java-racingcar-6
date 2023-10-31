package racingcar.View.output;

import racingcar.dto.MidGameResultDto;
import racingcar.model.RacingCar;

import java.util.ArrayList;

public class OutputFormatter {
    public String midGameResultMessage(MidGameResultDto midGameResultDto) {
        StringBuilder midGameResultVisualizationBuilder = new StringBuilder();
        midGameResultVisualizationBuilder
                .append(midGameResultDto.getRacingCarName())
                .append(" : ")
                .append(distanceVisualization(midGameResultDto.getDistance()));
        return midGameResultVisualizationBuilder.toString();
    }

    private String distanceVisualization(int distance) {
        return "-".repeat(distance);
    }

    public String winnerAnnouncementMessage(ArrayList<RacingCar> winnerList) {
        StringBuilder finalWinnerAnnouncementBuilder = new StringBuilder();
        String WinnerNameLastOfTheList = winnerList.get(winnerList.size() - 1).getName();
        String finalWinnerList = writeFinalWinnerAnnouncementList(winnerList, WinnerNameLastOfTheList);
        finalWinnerAnnouncementBuilder.append("최종 우승자 : ").append(finalWinnerList);
        return finalWinnerAnnouncementBuilder.toString();
    }

    private String writeFinalWinnerAnnouncementList(ArrayList<RacingCar> winnerList, String lastWinner) {
        StringBuilder finalWinner = new StringBuilder();
        for (RacingCar racingCar : winnerList) {
            if (racingCar.getName().equals(lastWinner)) {
                finalWinner.append(racingCar.getName());
            }
            if (!racingCar.getName().equals(lastWinner)) {
                finalWinner.append(racingCar.getName()).append(", ");
            }
        }
        return finalWinner.toString();
    }

}
