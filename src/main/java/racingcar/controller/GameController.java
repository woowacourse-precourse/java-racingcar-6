package racingcar.controller;

import java.util.List;
import racingcar.entity.User;
import racingcar.service.GameService;

public class GameController {

    private final GameService gameService = new GameService();

    public Integer gameCount(){
        return gameService.getCount();
    }

    public void game(List<User> users){
        gameService.gameStart(users);
    }

    public List<User> winner(List<User> users){
        return gameService.winner(users);
    }
}
