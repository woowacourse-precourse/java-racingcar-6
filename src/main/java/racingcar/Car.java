package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;

    private CarState carState;

    private int carPosition;

    private String carStateMessage;

    public Car(String carName) {

        this.carName = carName;
        this.carStateMessage = "";

        determineCarState();
    }

    public String getCarName() {

        return carName;
    }

    public int getCarPosition() {

        return carPosition;

    }

    // TODO: 게임 실행 시 처음에 "-" 이 두 번씩 출력되는 현상이 발생

    /**
     * 사용자가 입력한 시도할 횟수의 한 번 당 챕터 1 이라고 생각했을 때 (예시 : 시도할 횟수가 5라면 5챕터가 된다)
     * 컴퓨터는 각 챕터 당 각 자동차들의 랜덤 숫자를 생성한다
     * 그렇게 생성된 랜덤 숫자에 따라서 각 자동차들의 전진과 멈춤이 결정되고 "자동차 이름 : 전진 or 멈춤" 을 출력한다
     * (여기서 전진은 "-" 을 출력하고, 멈춤은 "" 을 출력하지만 실질적으로는 아무것도 출력하지 않는다)
     * 이어서 두 번째 챕터에서는 첫 번째 챕터에서 출력된 각 자동차들의 상태(전진 or 멈춤)에 이어서 전진과 멈춤을 출력한다
     * 이러한 과정을 사용자가 입력한 시도할 횟수만큼 반복한다
     */

    public void determineCarState() {

        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber > 3) {

            carState = CarState.MOVE;
            carPosition++;
            carStateMessage += "-";

        } else {

            carState = CarState.STOP;

        }
    }

    public String getCarStateMessage() {

        return carStateMessage;
    }
}
