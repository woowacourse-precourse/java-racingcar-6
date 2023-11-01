package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        String[] names = user.Name();
        Car[] cars = new Car[names.length];
        int number = user.Try();

    }

    public static class User {
        public String[] Name() {
            System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String CarNames = Console.readLine();
            String[] CarNamesArray = CarNames.split(",");
            List<String> CarNamesList = new ArrayList<>();
            for (int i = 0; i < CarNamesArray.length; i++) {
                CarNamesList.add(CarNamesArray[i]);
            }
            System.out.print(CarNamesList);
            int CarNameSize = CarNames.length();
            if (CarNameSize > 5 || CarNameSize == 0) {
                throw new IllegalArgumentException();
            }
            return CarNamesArray;
        }
        public int Try() {
            System.out.print("시도할 회수는 몇회인가요?");
            int TryNum = 0;
            try {
                TryNum = Integer.parseInt(Console.readLine());
            } catch (InputMismatchException ime) {
                throw new IllegalArgumentException("숫자를 입력해주세요");
            }
            return TryNum;
        }
    }

    public static class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
            this.name = name;
        }

        public void MoveOrNot() {
            if (RandomNum() >= 4) {
                position += 1;
            }
        }

        public int RandomNum() {
            int RandomNum = Randoms.pickNumberInRange(0, 9);
            return RandomNum;
        }

        public void Trace() {
            System.out.println(name + " : ");
            for (int i = 0; i < position; i++) {
                System.out.println("-");
            }
            System.out.println();
        }

        public int GetPosition() {
            return position;
        }

        public String GetName() {
            return name;
        }
    }

    public class Winners {

        public void ResultCar(int number, Car[] cars) {
            for (int j = 0; j < number; j++) {
                for (int i = 0; i < cars.length; i++) {
                    cars[i].MoveOrNot();
                    cars[i].Trace();
                }
                System.out.println();
            }
        }

        public static void Winner(Car[] cars) {
            String name = "";
            int max = -1;
            for (int i = 0; i < cars.length; i++) {

                if (cars[i].GetPosition() == max) {
                    name = name + ", " + cars[i].GetName();
                }
                if (cars[i].GetPosition() > max) {
                    name = cars[i].GetName();
                    max = cars[i].GetPosition();
                }
            }
            System.out.println("최종 우승자: " + name);
        }
    }
}
