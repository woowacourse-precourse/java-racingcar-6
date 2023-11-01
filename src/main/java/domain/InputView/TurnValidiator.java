package domain.InputView;

import static message.ErrorMessages.NEGATIVE_INPUT_ERROR;

public class TurnValidiator {

    public TurnValidiator(String num){
        int newnum= checkNumber(num);
        if(newnum<0){
            throw new IllegalArgumentException(NEGATIVE_INPUT_ERROR);
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
