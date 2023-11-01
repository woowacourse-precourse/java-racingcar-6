package racingcar.controller;

import racingcar.controller.util.PlayRule;
import racingcar.model.Cars;
import racingcar.view.RacingView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final RacingView racingView;
    private int tryNum;
    private List<Cars> carsList;

    private final PlayRule rules;

    public GameController(RacingView racingView, PlayRule rules) {
        this.racingView = racingView;
        this.rules = rules;
    }


    public void gameStart() {
        List<String> resultList = racingView.gameStart();
        this.carsList = new ArrayList<>();

        int index = 0;
        for (String car : resultList) {
            if (index == 0) {
//                게임 회전 횟수
                this.tryNum = rules.getRound(car);
            }
            if (index != 0) {
                carsList = rules.addCar(car, carsList);
            }
            index++;
        }
    }

    public void gameOn() {
        for (int i = 0; i < tryNum; i++) {
//            다이스 회전 돌고 결과 저장
            rules.playDices(this.carsList);
            gameLog(this.carsList);
        }
        String result = rules.getResult(this.carsList);
        racingView.showResult(result);
    }

    public void gameLog(List<Cars> carsList) {
        List<String> names = new ArrayList<>();
        List<String> locations = new ArrayList<>();

        for (Cars car : carsList) {
            names.add(car.getName());
            locations.add(car.getLoadState());
        }
        racingView.showLoad(names, locations);
    }
}
