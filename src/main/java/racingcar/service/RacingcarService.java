package racingcar.service;

import racingcar.domain.Racingcar;

import java.util.ArrayList;

public interface RacingcarService {

    void joinRacingcar(String nameList);

    ArrayList<Racingcar> changeMoving();

    ArrayList<String> selectWinner();

    void initStore();
}
