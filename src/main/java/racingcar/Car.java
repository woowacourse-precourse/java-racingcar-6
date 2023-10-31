package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
/*
추가된 요구 사항
        indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
        예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
        힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
        3항 연산자를 쓰지 않는다.
        함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.*/
/* [ ] (1) 자동차는 전진 또는 멈출 수 있다. -> carMoveOrStop()
   [ ] (2) 각 자동차에 이름을 부여할 수 있다. -> giveNameOfCar()
   [ ] (3) 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. -> printMovingCarWithCarName()
   [v] (4) 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. -> isLengthFive()
   [v] (6) 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. -> isMoveAble()
       [v] (6-1) 무작위 값을 구하는 메서드 generateRandomNumber()
   [ ] (7) 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. -> returnWinner() */

public class Car {
    private String carName;
    public boolean carMoveOrStop() {
        return false;
    }

    public void giveNameOfCar(String carName) {
        if(isLengthFive(carName)) {
            this.carName = carName;
        }
    }
/*
[ ] (2) 각 자동차에 이름을 부여할 수 있다. -> giveNameOfCar()
    각자의 자동차에 이름을 부여해야함 즉,해당 인스턴스마다 새로운 이름을 부여
    하지만 자동차의 이름은 ","을 구분자로 하여 한 줄에 쭉 입력되기 때문에
    해당 자동차의 이름들을 List<String> 형태로 split한다음 각각의 Car에 입력해야 함.
    -> 그렇다면 해당 메서드는 List<String>의 값들을 읽어서 해당 값을
    Car 내의 carName이라는 변수에 저장해야 한다. 즉, setter의 역할.
[ ] (3) 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. ->
printMovingCarWithCarName()
[ ] (4) 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
 -> isLengthFive()
*/

    public String printMovingCarWithCarName() {
        return "";
    }

    public boolean isLengthFive(String carName) {
        return carName.length() <= 5;
    }

    public boolean isMoveAble() {
        return generateRandomNumber() > 3;
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
