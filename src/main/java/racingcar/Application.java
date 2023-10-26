package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    class Car{
        private final int forward;
        private final String name;

        public Car(String inputName){
            this.forward = Randoms.pickNumberInRange(0, 9);
            this.name = inputName;
        }

        public int getForward(){
            return forward;
        }
        public String getName(){
            return name;
        }

    }
}
