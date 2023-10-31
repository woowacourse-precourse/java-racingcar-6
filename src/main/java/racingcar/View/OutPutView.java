package racingcar.View;

import racingcar.dto.MidGameResultDto;
import racingcar.model.RacingCar;

import java.util.ArrayList;

public class OutPutView {

    public void resultAnnouncementMessage() {
        System.out.println("실행 결과");
    }

    public void midGameResultMessage(ArrayList<MidGameResultDto> midGameResultDtoList) {
        StringBuilder midGameResultVisualizationBuilder = new StringBuilder();
        for (MidGameResultDto gameResultDto : midGameResultDtoList) {
            midGameResultVisualizationBuilder
                    .append(gameResultDto.getRacingCarName())
                    .append(" : ")
                    .append(distanceVisualization(gameResultDto.getDistance()));
            printMidGameResult(midGameResultVisualizationBuilder);
            midGameResultVisualizationBuilder.setLength(0);
        }
    }

    private String distanceVisualization(int distance) {
        return "-".repeat(distance);
    }

    private void printMidGameResult(StringBuilder midGameResultVisualizationBuilder) {
        System.out.println(midGameResultVisualizationBuilder);
    }

    public void winnerAnnouncementMessage(ArrayList<RacingCar> winnerList) {
        StringBuilder finalWinnerAnnouncementBuilder = new StringBuilder();
        String WinnerNameLastOfTheList = winnerList.get(winnerList.size() - 1).getName();
        String finalWinnerList = writeFinalWinnerAnnouncementList(winnerList, WinnerNameLastOfTheList);
        finalWinnerAnnouncementBuilder.append("최종 우승자 : ").append(finalWinnerList);
        printFinalWinnerAnnouncementList(finalWinnerAnnouncementBuilder);
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

    private void printFinalWinnerAnnouncementList(StringBuilder finalWinnerAnnouncementBuilder) {
        System.out.println(finalWinnerAnnouncementBuilder);
    }
}