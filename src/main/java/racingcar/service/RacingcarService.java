package racingcar.service;

import racingcar.domain.Racingcar;

import java.util.ArrayList;

public interface RacingcarService {

    public void joinRacingcar(String nameList);

    public ArrayList<Racingcar> changeMoving();

    public ArrayList<String> selectWinner();
}
