package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

        public static void main(String[] args) {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String participantInputName = Console.readLine();
                List<Car> participants = RacingController.participantsInput(participantInputName);        // 이름 저장

                System.out.println("시도할 회수는 몇회인가요?");
                String inputMoves = Console.readLine();
                RacingController.attemptInput(participants, inputMoves); //시도 회수 저장 및 진행 상황 출력

                RacingController.victory(participants);    // 우승자 출력
        }
}

class RacingController {
        public static List<Car> participantsInput(String participantInputName) {
                List<Car> participants = new ArrayList<>();
                String[] names = participantInputName.split(",");
                for (int i = 0; i < names.length; i++) {
                        String name = names[i];
                        validateName(participants, name);
                        participants.add(new Car(name, 0));
                }

                String participant = String.join(", ", names);
                System.out.println(participant);
                return participants;
        }

        public static void validateName(List<Car> participants, String name) {
                for (Car car : participants) {
                        if (car.equals(new Car(name, 0))) {
                                System.out.println("중복된 이름이 있습니다.");
                                throw new IllegalArgumentException();
                        }
                }
                if (name.length() > 5 || name.length() == 0) {
                        System.out.println("5글자 이상의 이름이 있습니다.");
                        throw new IllegalArgumentException();
                }
        }

        public static void attemptInput(List<Car> participants, String inputMoves) {
                System.out.println("실행 결과");
                int intMove = Integer.parseInt(inputMoves);
                for (int i = 0; i < intMove; i++) {
                        for (Car car : participants) {
                                car.move();
                                System.out.println(car.getName() + " : " + car.getMoveStatus());
                        }
                }
        }

        public static void victory(List<Car> participants) {
                int maxMove = 0;
                List<String> winner = new ArrayList<>();
                for (Car car : participants) {
                        int carMove = car.getMove();
                        if (carMove > maxMove) {
                                maxMove = carMove;
                                winner.clear();
                                winner.add(car.getName());
                        } else if (carMove == maxMove) {
                                winner.add(car.getName());
                        }
                }
                System.out.println("최종 우승자 : " + String.join(", ", winner));
        }
}

// Ming,Seo,Park,Bin,Seong
class Car {
        private String name;
        private int move;

        public Car(String name, int i) {
                this.name = name;
                this.move = 0;
        }

        public String getName() {
                return name;
        }

        public int getMove() {
                return move;
        }

        public String getMoveStatus() {
                return "-".repeat(move);
        }

        public void move() {
                int random = Randoms.pickNumberInRange(0, 9);
                if (random >= 4) {
                        move += 1;
                }
        }
}