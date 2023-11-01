package racingcar.view;


import java.util.List;

public class RacingOutput {

    public void racingCarName (List<String>carList, int carOrder) {

        List<String> carNames = carList;

        System.out.print(carNames.get(carOrder)+ " : ");

    }

    public void carMovingView(List<Integer> forwardPointList, List<String> carList) {

        for (int carOrder = 0; carOrder <forwardPointList.size(); carOrder++) {

            racingCarName(carList,carOrder);

            for (int i = 0; i < forwardPointList.get(carOrder); i++) {

                System.out.print(RacingGameDescription.carMovingMotion);

            }
            System.out.println();
        }
    }

    public void carRacing (List<Integer> forwardPointList, List<String> carList ){

        carMovingView(forwardPointList,carList);
        System.out.println();

    }

}
