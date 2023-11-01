package racingcar;

import java.math.BigInteger;

public class MakeRound {
    public BigInteger makeRound(){
        Utils utils = new Utils();
        IntegrityCheck integrityCheck = new IntegrityCheck();
        String round;

        System.out.println("시도할 회수는 몇회인가요?");
        round = utils.inputStr();
        if (integrityCheck.intIntegrityCheck(round)){
            throw new IllegalArgumentException();
        }
        return new BigInteger(round);
    }
}
