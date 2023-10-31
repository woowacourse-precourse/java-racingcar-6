package racingcar;

public class MakeRound {
    public int makeRound(){
        Utils utils = new Utils();
        IntegrityCheck integrityCheck = new IntegrityCheck();
        String round;

        round = utils.inputStr();
        if (integrityCheck.intIntegrityCheck(round)){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(round);
    }
}
