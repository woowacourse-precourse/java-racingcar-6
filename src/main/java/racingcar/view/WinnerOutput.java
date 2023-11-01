package racingcar.view;

import java.util.List;

public class WinnerOutput {

    public void winnerOutputs (List<String> winnerList,int winnerNum)  {

        if(winnerNum == 1){
            soloWinner(winnerList);
        }
        if(winnerNum > 1){
            multiWinner(winnerList);
        }

    }

    public void soloWinner(List<String> winnerList){

        System.out.print(RacingGameDescription.finalWinner+ winnerList.get(0));
    }

    public void multiWinner(List<String> winnerList){

        System.out.print(RacingGameDescription.finalWinner);
        multiWinnerOutputForm(winnerList);
    }

    public void multiWinnerOutputForm(List<String> winnerList){

        for (int i= 0; i < winnerList.size(); i++) {

            System.out.print(winnerList.get(i));

            if (i != (winnerList.size())-1) {
                System.out.print(", ");
            }
        }
    }

}
