package racingcar;

import static racingcar.Constants.*;
import static racingcar.Exception.checkCarNameLengthOver;
import static racingcar.Exception.checkInteger;
import static racingcar.Exception.checkWithinRange;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    private List<Car> carList;
    private Integer tryNumber;

    public Game() {
        this.carList = new ArrayList<>();
        this.tryNumber = 0;
    }

    public void run() {
        alertEnterCarName();
        saveCarName();
        alertEnterTryNumber();
        saveTryNumber();
        while (tryNumber > 0) {
            race();
            tryNumber--;
        }
        informWinner();
    }

    private void alertEnterCarName() {
        System.out.println(ALERT_ENTER_CAR);
    }

    private void saveCarName() {
        String readLine = Console.readLine();
        String[] names = readLine.split(CAR_DIVISION);

        if (readLine.endsWith(",")) {
            names = getAddNamesArray(names);
        }
        if(names.length == 0 || isMatchedPattern(readLine)) {
            names = checkEmptyCarName(readLine);
        }
        checkCarNameLengthOver(names);
        addCar(names);
    }

    private void alertEnterTryNumber() {
        System.out.println(ALERT_ENTER_TRY_NUMBER);
    }

    private void saveTryNumber() {
        String readLine = Console.readLine();
        tryNumber = convertStringToInteger(readLine);

        checkInteger(tryNumber);
        checkWithinRange(tryNumber);
    }

    private void race() {
        for(Car car : carList) {
            if (isMoveForward()) {
                car.addForward();
            }
            System.out.print(car.getName() + CAR_IS);
            System.out.println(car.getForward());
        }
        System.out.println();
    }

    private void informWinner() {
        List<String> winnerNames = pickWinner();

        System.out.print(ALERT_WINNER_IS);
        String result = arrangeWinner(winnerNames);
        System.out.println(result);
    }

    private Boolean isMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        if (randomNumber >= MOVE_FORWARD_MIN) {
            return true;
        }
        return false;
    }

    private String[] getAddNamesArray(String[] names) {
        String[] newNames = new String[names.length + 1];
        System.arraycopy(names, 0, newNames, 0, names.length);
        newNames[names.length] = makeRandomName();
        names = newNames;
        return names;
    }

    private Boolean isMatchedPattern(String readLine) {
        String condition = "^[,\\s]*$";
        Pattern pattern = Pattern.compile(condition);
        Matcher matcher = pattern.matcher(readLine);
        return matcher.matches();
    }

    private static String[] checkEmptyCarName(String readLine) {
        if (readLine.isEmpty()) {
            return new String[]{makeRandomName()};
        }
        if (!readLine.contains(CAR_DIVISION)) {
            return new String[]{readLine};
        }
        Integer carNumber = countEmptyCarName(readLine);
        String[] newNames = new String[carNumber];
        fullWithRandomName(newNames);
        return newNames;
    }

    private static Integer countEmptyCarName(String readLine) {
        Integer count = 0;
        for (int i = 0; i < readLine.length(); i++) {
            if (readLine.charAt(i) == CAR_DIVISION_CHAR) {
                count++;
            }
        }
        return count + 1;
    }

    private static void fullWithRandomName(String[] newNames) {
        for (int i = 0; i < newNames.length; i++) {
            newNames[i] = makeRandomName();
        }
    }

    private static String makeRandomName() {
        String characters = UPPER_CASE;
        StringBuilder sb = new StringBuilder(RANDOM_NAME_LENGTH);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < RANDOM_NAME_LENGTH; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    private void addCar(String[] nameArray) {
        for (String name : nameArray) {
            carList.add(new Car(name));
        }
    }

    private Integer convertStringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private List<String> pickWinner() {
        List<String> winnerNames = new ArrayList<>();
        int maxForward = 0;
        for (Car car : carList) {
            if (maxForward == car.getForwardNumber()) {
                winnerNames.add(car.getName());
            }
            if (maxForward < car.getForwardNumber()) {
                winnerNames.clear();
                winnerNames.add(car.getName());
                maxForward = car.getForwardNumber();
            }
        }
        return winnerNames;
    }

    private String arrangeWinner(List<String> winnerNames) {
        return String.join(WINNER_DIVISION, winnerNames);
    }
}
