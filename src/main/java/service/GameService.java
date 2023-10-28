package service;

import camp.nextstep.edu.missionutils.Randoms;

import domain.Game;

public class GameService {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int FORWARD_CONDITION = 4;
    
    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
