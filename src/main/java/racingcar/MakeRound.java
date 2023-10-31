package racingcar;

public class MakeRound {
    public int makeRound(){
        Utils utils = new Utils();
        IntegrityCheck integrityCheck = new IntegrityCheck();
        String round;

        System.out.println("시도할 회수는 몇회인가요?");
        round = utils.inputStr();
        if (integrityCheck.intIntegrityCheck(round)){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(round);
    }
}
