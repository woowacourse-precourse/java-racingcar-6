package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class CarMover {
    private List<Boolean> decideToMoveCars(int n)
    {
        List<Boolean> whetherMoveOrNot = new ArrayList<>();
        for(int i = 0 ; i<n ; i++)
        {
            int pickedRandomNumber = Randoms.pickNumberInRange(0, 9);
            if(pickedRandomNumber >= 4)
            {
                whetherMoveOrNot.add(true);
            }
            else
            {
                whetherMoveOrNot.add(false);
            }
        }

        return whetherMoveOrNot;
    }

    private List<Integer> moveEveryCar(int n, List<Integer> carList, List<Boolean> whetherMoveOrNot)
    {
        for(int i = 0 ; i<n ; i++)
        {
            if(whetherMoveOrNot.get(i))
            {
                carList.set(i, carList.get(i) + 1);
            }
        }
        return carList;
    }
}
