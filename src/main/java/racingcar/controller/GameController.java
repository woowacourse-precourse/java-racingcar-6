package racingcar.controller;

import racingcar.model.GameMember;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    GameMember gameMember = new GameMember();
    InputValidator inputValidator = new InputValidator();
    GenerateRandomNum generateRandomNum = new GenerateRandomNum();

    public void proceedGame(){
        setCarPlayers();
        setTryNum();
        for(int i=0 ; i<gameMember.getTryNum() ; i++){
            goGame();
            outputView.gameProgress(gameMember.getHs(),gameMember.getCarPlayers());
        }


    }
    private void goGame(){
        for(String key : gameMember.getCarPlayers()){
            if(generateRandomNum.pickNum()){
                gameMember.setDuringGame(key);
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
