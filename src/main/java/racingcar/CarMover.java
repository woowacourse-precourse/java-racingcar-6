package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class CarMover {
    public List<Boolean> decideToMoveCars(int n)
    {
        List<Boolean> whetherMoveOrNot = new ArrayList<>();
        for (int i = 0 ; i<n ; i++)
        {
            int pickedRandomNumber = Randoms.pickNumberInRange(0, 9);
            if (pickedRandomNumber >= 4)
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

    public void moveEveryCar(int n, List<Car> carList, List<Boolean> whetherMoveOrNot)
    {
        for (int i = 0 ; i<n ; i++)
        {
            Car car = carList.get(i);
            if (whetherMoveOrNot.get(i))
            {
                car.setDistance(car.getDistance() + 1);
            }
        }
    }
}
