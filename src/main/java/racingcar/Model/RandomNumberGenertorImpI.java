package racingcar.Model;


import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenertorImpI implements RandomNumberGenerator{

    @Override
    public int nextInt(int bound){
        return Randoms.pickNumberInRange(0,bound);
    }
}
