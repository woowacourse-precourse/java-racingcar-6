package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
import racingcar.utils.Trials;
import racingcar.utils.UserList;
import racingcar.utils.GoStop;
import racingcar.view.SettingView;
import racingcar.view.ProcessView;
import racingcar.view.AnnouncementView;



public class Controller {

    private static List<Car> Users = new ArrayList<>();
    private static int trials;
    public static void Game() {
        initialize();
        running();
        AnnounceWinner();
    }

    private static void initialize() {
        SettingView.getCarNames();
        Users = UserList.getCarList();
        SettingView.getTrialNums();
        trials = Trials.getTrials();
    }
    private static void running() {
        for (int i = 0; i<trials; i++) {
            GoStop.oneTurn(Users);
            ProcessView.printMovement(Users);
        }
    }
    private static void AnnounceWinner() {
        AnnouncementView.finalWinner(Users);
    }

}
