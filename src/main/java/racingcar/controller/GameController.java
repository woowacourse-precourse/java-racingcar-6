package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.GameMember;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    GameMember gameMember = new GameMember();
    InputValidator inputValidator = new InputValidator();
    GenerateRandomNum generateRandomNum = new GenerateRandomNum();

    public void proceedGame() {
        setCarPlayers();
        setTryNum();
        for (int i = 0; i < gameMember.getTryNum(); i++) {
            goGame();
            outputView.gameProgress(gameMember.getHs(), gameMember.getCarPlayers());
        }
        System.out.println("최종 우승자 : " + whoIsWinner(gameMember.getHs(), gameMember.getCarPlayers()));


    }

    private String whoIsWinner(HashMap<String, String> hs, List<String> carPlayers) {
        int max = maxLength(hs, carPlayers);
        List<String> winner = new ArrayList<>();
        for (String key : carPlayers) {
            if (max == hs.get(key).length()) {
                winner.add(key);
            }
        }
        String join = String.join(",", winner);
        return join;
    }

    private int maxLength(HashMap<String, String> hs, List<String> carPlayers) {
        int max = 0;
        for (String key : carPlayers) {
            if (max < hs.get(key).length()) {
                max = hs.get(key).length();
            }
        }

        return max;
    }

    private void goGame() {
        for (String key : gameMember.getCarPlayers()) {
            if (generateRandomNum.pickNum(Randoms.pickNumberInRange(0, 9))) {
                gameMember.setDuringGame(key);
            }
        }
    }

    private void setCarPlayers() {
        gameMember.setCarPlayers(inputValidator.toValidateData(inputView.enterGameMembersName()));
        gameMember.setHs(gameMember.getCarPlayers());
    }

    private void setTryNum() {
        gameMember.setTryNum(Integer.parseInt(inputValidator.toValidateTryNum(inputView.enterGameNumber())));
//        gameMember.setTryNum(Integer.parseInt(inputView.enterGameNumber()));
        System.out.println("");
        System.out.println("실행 결과");
    }

}
