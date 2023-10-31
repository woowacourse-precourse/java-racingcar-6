package racingcar.controller;

import racingcar.model.GameMember;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class GameController {
    InputView inputView = new InputView();
    GameMember gameMember = new GameMember();
    InputValidator inputValidator = new InputValidator();
    GenerateRandomNum generateRandomNum = new GenerateRandomNum();

    public void proceedGame(){
        setCarPlayers();
        setTryNum();
        repeatGame();
    }
    private void repeatGame(){
        for(int i=0 ; i<gameMember.getTryNum() ; i++){
            if(generateRandomNum.pickNum()){

            }
        }
    }

    private void setCarPlayers(){
        gameMember.setCarPlayers(inputValidator.toValidateData(inputView.enterGameMembersName()));
        gameMember.setHs(gameMember.getCarPlayers());
    }
    private void setTryNum(){
        gameMember.setTryNum(inputView.enterGameNumber());
    }

}
