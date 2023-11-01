package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Cars {
    private final static String COMMA = ",";
    private final static String WINNER_COMMA = ", ";
    private final static String WINNER_MESSAGE = "최종 우승자 : ";
    private final static int MAX_LENGTH = 5;
    private final static int ZERO = 0;

    private List<Car> list;

    public void inputCarName(String input) {
        this.list = splitCarName(input);
    }

    private List<Car> splitCarName(String input) {
        List<String> names = Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .toList();
        checkValid(names);
        return createCar(names);
    }

    private List<Car> createCar(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void checkValid(List<String> names) {
        if (!checkValidName(names)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkValidName(List<String> names) {
        return isNotDuplicate(names)
                && isValidName(names);
    }

    private boolean isNotDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        return names.size() == uniqueNames.size();
    }

    private boolean isValidName(List<String> names) {
        for (String name : names) {
            if (isOverMaxLength(name) || isBlank(name)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOverMaxLength(String name) {
        return name.length() > MAX_LENGTH;
    }

    private boolean isBlank(String name) {
        return name.length() == ZERO;
    }

    public void moveCars() {
        for (Car car : this.list) {
            if (canMove()) {
                car.moveCar();
            }
        }
    }

    private boolean canMove() {
        return pickNumberInRange(0, 9) >= 4;
    }

    public void printResult() {
        printResultByCar();
        System.out.println();
    }

    private void printResultByCar() {
        for (Car car : list) {
            car.printPositionWithName();
        }
    }

    public void printWinner() {
        System.out.print(WINNER_MESSAGE);
        System.out.println(createWinner());
    }

    public String createWinner() {
        int position = findFrontPosition();
        List<String> winner = findWinnerName(position);
        return String.join(WINNER_COMMA, winner);
    }

    private int findFrontPosition() {
        int position = ZERO;
        for (Car car : list) {
            if (position < car.getPosition()) {
                position = car.getPosition();
            }
        }
        return position;
    }

    private List<String> findWinnerName(int position) {
        List<String> winner = new ArrayList<>();
        for (Car car : list) {
            if (position == car.getPosition()) {
                String carName = car.getName();
                winner.add(carName);
            }
        }
        return winner;
    }
}
