package racingcar.View;

import racingcar.dto.GameResultDto;
import racingcar.model.RacingCar;

import java.util.ArrayList;

public class OutPutView {

    public void resultAnnouncementMessage() {
        System.out.println("실행 결과");
    }
    public void midGameResultMessage(ArrayList<GameResultDto> midGameResultDtoList) {
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

    public void winnerAnnouncementMessage(ArrayList<RacingCar> winnerList) {
        String finalWinnerList = null;
        System.out.print("최종 우승자 : ");
        if (winnerList.size() > 0) {
            String lastWinner = winnerList.get(winnerList.size() - 1).getName();
            finalWinnerList = writeFinalWinnerList(winnerList, lastWinner);
            System.out.println(finalWinnerList);
        }
        if (winnerList.size() == 0) {
            System.out.println(winnerList.get(0));
        }
    }

    private String writeFinalWinnerList(ArrayList<RacingCar> winnerList, String lastWinner) {
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