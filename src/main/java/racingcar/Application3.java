//package racingcar;
//
//import camp.nextstep.edu.missionutils.Randoms;
//import camp.nextstep.edu.missionutils.Console;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class Application3 {
//
//    public static void main(String[] args) {
//
//        //String carNamesInput = console.readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
////        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
//       // String carNamesInput = Console.readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
////        Console console = Console.getInstance(); - 이줄은 필요없음
//        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) : ");
//        String carNamesInput = Console.readLine();
//        String[] carNames = carNamesInput.split(",");
//        // car name 길이 예외처리
//        for(int i=0; i < carNames.length ; i++) {
//            String strName = carNames[i];
//            try {
//                parseStrWithValidation(strName);
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//                System.exit(1); // 프로그램 비정상 종료
//            }
//        }
//
//        // 시도할 횟수(인풋)에 대한 예외처리
//        // int numberOfAttempts = Integer.parseInt(console.readLine("시도할 회수는 몇회인가요?"));
//        int numberOfAttempts = 0;
//        try {
//            System.out.println("시도할 회수는 몇회인가요?");
//            numberOfAttempts = Integer.parseInt(Console.readLine());
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            System.exit(1); // 프로그램 비정상 종료
//        }
//
//        Race race = new Race(carNames);
//        race.start(numberOfAttempts);
//        race.printRaceResult();
//    }
//    private static int parseStrWithValidation(String message) {
//
//        if (message.length() > 5) {
//            throw new IllegalArgumentException("올바른 5글자 이내의 carname을 입력하세요.");
//        }
//        return 0;
//    }
//    private static int parseIntWithValidation(Console console, String message) {
//        String input = console.readLine();
//        if (!isInteger(input)) {
//            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
//        }
//        return Integer.parseInt(input);
//    }
//    public static boolean isInteger(String input) {
//        return input.matches("^\\d+$");
//    }
//}
//
//
//class Race {
//    private final List<Car> cars;
//
//    public Race(String[] carNames) {
//        cars = initializeCars(carNames);
//    }
//
//    private List<Car> initializeCars(String[] carNames) {
//        return Arrays.stream(carNames).map(Car::new).toList();
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
//            car.move();
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
//        List<String> winners = getWinners();
//        System.out.println("\n최종 우승자: " + String.join(", ", winners));
//    }
//
//    private List<String> getWinners() {
//        int maxPosition = getMaxPosition();
//        return extractWinnerNames(maxPosition);
//    }
//
//    private int getMaxPosition() {
//        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
//    }
//
//    private List<String> extractWinnerNames(int maxPosition) {
//        return cars.stream()
//                .filter(car -> car.getPosition() == maxPosition)
//                .map(Car::getName)
//                .toList();
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
//        int randomNumber = Randoms.pickNumberInRange(0, 9);
//        if (randomNumber >= MOVE_THRESHOLD) {
//            position++;
//        }
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
