package racingcar.Service;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;

public class RandomAdvanceOrstop {

    private final static int MIN_RANDOM_NUMBER = 0;
    private final static int MAX_RANDOM_NUMBER = 9;
    private final static int ADVANCE_NUMBER = 4;
    public String advanceString = new String("-");

    UserInput userInput = new UserInput();

    Car car;

    public void judgeAdvanceOrStop() {
        //몇번 시도할지 입력 했음 car.tryNumber 가져와서 for문 car.tryNumber.length 만큼 돌려주기
        for (int i = 0; i < car.tryNumber; i++) {
            advanceOrStop();
        }
    }

    private void advanceOrStop()  {   //전진하는 메소드, 출력

        for (int j = 0; j < (car.carList).length; j++) {
            int judgeNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            if (judgeNumber >= ADVANCE_NUMBER){ //4이상이라면 전진
                car.carList[j] = car.carList[j].concat(advanceString);
                System.out.println(car.carList[j]); //전진인 차는 + "-"되서 출력
            }
            else{
                System.out.println(car.carList[j]);//멈춤인 차는 그대로 출력
            }
        }
    }
}