package racingcar.view;

import java.util.List;

import racingcar.model.Car;
import racingcar.utils.GetWinner;


public class AnnouncementView {

    public static void finalWinner(List<Car> Users) {
        System.out.print("최종 우승자 : ");
        List<String> Winners = GetWinner.winnerList(Users);
        for (int i = 0; i <Winners.size(); i++) {
            System.out.print(Winners.get(i));
            if (i < Winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
