package domain.InputValues;

public class TurnValidiator {

    public TurnValidiator(String num){
        int newnum= checkNumber(num);
        if(newnum<0){
            throw new IllegalArgumentException("입력된 숫자가 음수입니다.");
        }

    }

    private int checkNumber(String turnNum)
    {
        try {
            return Integer.parseInt(turnNum);

        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }


}
