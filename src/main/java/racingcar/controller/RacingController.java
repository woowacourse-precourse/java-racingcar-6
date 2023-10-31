package racingcar.controller;

import static racingcar.controller.InputValidator.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.RacingModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private RacingModel racingModel;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public RacingController(RacingModel racingModel) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingModel = racingModel;
    }

    public void startRacing() {

        racingSetting();
        racingPlay();
        racingResult();

    }

    private void racingSetting() { // 플레이어들의 이름과 횟수를 설정하는 함수

        outputView.printStarting();
        List<String> players = nameValidation(inputView.inputPlayers());
        outputView.printTimes();
        int number = numberValidation(inputView.inputTimes());

        racingModel = new RacingModel(players, number);

    }

    private void racingPlay() { // 반복 횟수만큼 moving_distance값을 업데이트하고 출력

        List<String> players = racingModel.getPlayers();

        outputView.printResult();
        for (int i = 0; i < racingModel.getNumber_of_times(); i++) {

            racing_Play_Onetime();
            outputView.printRacing(players, racingModel.getMoving_distance());

        }

    }

    private void racing_Play_Onetime() { // 랜덤값이 4 이상이면 전진하는 것을 player마다 한번씩 수행하고 moving_distance업데이트

        int[] distance_list = racingModel.getMoving_distance();

        for (int j = 0; j < distance_list.length; j++) {
            if (Randoms.pickNumberInRange(1, 9) >= 4) {
                distance_list[j] += 1;
            }
        }

        racingModel.setMoving_distance(distance_list);

    }

    public void racingResult() { // 최종 수행 결과 우승자를 판단하고 출력하는 함수

        List<Integer> winner_index = racingWinner();
        List<String> players = racingModel.getPlayers();

        List<String> winner_list = new ArrayList<>();

        for (int index : winner_index) {
            winner_list.add(players.get(index));
        }
        String winner = String.join(", ", winner_list);

        outputView.printWinner(winner);

    }

    private List<Integer> racingWinner() { // 최종 우승자들을 판별하는 함수

        int[] distance_list = racingModel.getMoving_distance();
        List<Integer> winner_index = new ArrayList<>();

        winner_index.add(0);

        for (int index = 1; index < distance_list.length; index++) {
            winner_index = comparePlayer(distance_list, winner_index, index);
        }

        return winner_index;

    }

    // 이동거리를 비교하는 함수
    private List<Integer> comparePlayer(int[] distance_list, List<Integer> winner_index, int index) {

        if (distance_list[winner_index.get(0)] < distance_list[index]) {
            winner_index.clear();
            winner_index.add(index);
        } else if (distance_list[winner_index.get(0)] == distance_list[index]) {
            winner_index.add(index);
        }

        return winner_index;

    }

}
