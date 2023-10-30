package racingcar;

public class Application {
    public class Car {
        String name;
        int length;

        public Car(String name) {
            setName(name);
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setLength(int length) {
            this.length += length;
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
