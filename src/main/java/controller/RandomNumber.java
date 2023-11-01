package controller;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber implements RandomNumberInterface{
    @Override
    public int randomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
