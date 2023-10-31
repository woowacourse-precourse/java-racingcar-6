package domain.InputValues;

public class TurnValidiator {

    public TurnValidiator(String num){
        checkNumber(num);

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
