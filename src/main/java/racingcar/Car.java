package racingcar;

public class Car {
        private String name;
        private int position;

        public Car(String name) {
                this.name = name;
                this.position = 0;
        }

        public String getName() {
                return name;
        }

        public int getPosition() {
                return position;
        }

        public void move() {
                position++;
        }

        public void printCar() {
                System.out.print(name + " : ");
                for (int i = 0; i < position; i++) {
                        System.out.print("-");
                }
                System.out.println();
        }
}
