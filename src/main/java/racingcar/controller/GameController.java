package racingcar.controller;

import racingcar.model.GameMember;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class GameController {
    InputView inputView = new InputView();
    GameMember gameMember = new GameMember();
    InputValidator inputValidator = new InputValidator();
    GenerateRandomNum generateRandomNum = new GenerateRandomNum();

    private void setCarPlayers(){
        gameMember.setCarPlayers(inputValidator.toValidateData(inputView.enterGameMembersName()));
    }
    private void setTryNum(){
        gameMember.setTryNum(inputView.enterGameNumber());
    }

}
