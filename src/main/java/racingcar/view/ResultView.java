package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.model.CarModel;

public class ResultView {
    //Todo: 우승자 리스트 출력

    public void showWinnerCars(List<CarModel> winners) {
        String result = generateWinnerList(winners);

        System.out.println("최종 우승자 : " + result);
    }

    private static String generateWinnerList(List<CarModel> winners) {
        StringJoiner result = new StringJoiner(", ");

        for (CarModel winner : winners) {
            result.add(winner.getName());
        }
        return result.toString();
    }
}
