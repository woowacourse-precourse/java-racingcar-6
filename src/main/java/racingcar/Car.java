package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
        private String name;
        private int position;

        public Car(String name, int position) {
                this.name = name;
                this.position = position;
        }

        public String getName() {
                return name;
        }

        public int getPosition() {
                return position;
        }

        public void move() {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                if(randomValue >= 4) {
                        position++;
                }
        }

        public void printCar() {
                System.out.print(name + " : ");
                for (int i = 0; i < position; i++) {
                        System.out.print("-");
                }
                System.out.println();
        }
}
