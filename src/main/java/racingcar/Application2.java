//package racingcar;
//
//import camp.nextstep.edu.missionutils.Randoms;
//import camp.nextstep.edu.missionutils.Console;
//
//public class Application2 {
//
//    public static void main(String[] args) {
//        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분): ");
//        String carNamesInput = Console.readLine();
//        String[] carNames = carNamesInput.split(",");
//
//        // 자동차 이름 길이 검증
//        for (String carName : carNames) {
//            validateCarName(carName);
//        }
//
//        // 시도할 횟수 입력 및 검증
//        int numberOfAttempts = 0;
//        boolean validAttempts = false;
//        while (!validAttempts) {
//            try {
//                System.out.print("시도할 회수는 몇회인가요?: ");
//                String attemptsInput = Console.readLine();
//                numberOfAttempts = Integer.parseInt(attemptsInput);
//                validateAttempts(numberOfAttempts);
//                validAttempts = true;
//            } catch (NumberFormatException e) {
//                System.out.println("올바른 숫자를 입력하세요.");
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//        Race race = new Race(carNames);
//        race.start(numberOfAttempts);
//        race.printRaceResult();
//    }
//
//    private static void validateCarName(String carName) {
//        if (carName.length() > 5) {
//            throw new IllegalArgumentException("올바른 5글자 이내의 carname을 입력하세요.");
//        }
//    }
//
//    private static void validateAttempts(int numberOfAttempts) {
//        if (numberOfAttempts <= 0) {
//            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
//        }
//    }
//}
//
//class Race {
//    private final Car[] cars;
//
//    public Race(String[] carNames) {
//        cars = initializeCars(carNames);
//    }
//
//    private Car[] initializeCars(String[] carNames) {
//        Car[] initializedCars = new Car[carNames.length];
//        for (int i = 0; i < carNames.length; i++) {
//            initializedCars[i] = new Car(carNames[i]);
//        }
//        return initializedCars;
//    }
//
//    public void start(int numberOfAttempts) {
//        for (int i = 0; i < numberOfAttempts; i++) {
//            moveCars();
//            printCars();
//        }
//    }
//
//    private void moveCars() {
//        for (Car car : cars) {
//            int randomNumber = Randoms.pickNumberInRange(0,9); // 0부터 9까지의 랜덤 숫자
//            if (randomNumber >= 4) {
//                car.move();
//            }
//        }
//    }
//
//    private void printCars() {
//        for (Car car : cars) {
//            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
//        }
//        System.out.println("\n");
//    }
//
//    public void printRaceResult() {
//        int maxPosition = getMaxPosition();
//        System.out.print("최종 우승자: ");
//        boolean isFirst = true;
//        for (Car car : cars) {
//            if (car.getPosition() == maxPosition) {
//                if (!isFirst) {
//                    System.out.print(", ");
//                }
//                System.out.print(car.getName());
//                isFirst = false;
//            }
//        }
//    }
//
//    private int getMaxPosition() {
//        int maxPosition = 0;
//        for (Car car : cars) {
//            maxPosition = Math.max(maxPosition, car.getPosition());
//        }
//        return maxPosition;
//    }
//}
//
//class Car {
//    private static final int MOVE_THRESHOLD = 4;
//    private final String name;
//    private int position = 0;
//
//    public Car(String name) {
//        this.name = name;
//    }
//
//    public void move() {
//        position++;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getPosition() {
//        return position;
//    }
//}