package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.GameNum;

public class GameService {
    private final MessageService message = new MessageService();
    private Cars cars = new Cars();
    private GameNum gameNum = new GameNum();

    public void run() {
        message.printResult();
        List<String> carList = cars.find();
        int[] arr = new int[carList.size()];
        int max = 0;
        List<String> result = new ArrayList<>();
        List<String[]> process = new ArrayList<>();

        while (gameNum.find() > 0) {
            for (int i = 0; i < arr.length; i++) {
                int random = Randoms.pickNumberInRange(0, 9);
                if (random < 4) {
                    continue;
                }
                arr[i]++;
            }

            for (int i = 0; i < arr.length; i++) {
                message.printProcess(carList.get(i));
                for (int j = 0; j < arr[i]; j++) {
                    System.out.print("-");
                }
                max = Math.max(max, arr[i]);
                System.out.println();
            }

            System.out.println();
            gameNum.minus();
        }

        for (int i = 0; i < arr.length; i++) {
            process.add(new String[]{String.valueOf(arr[i]), carList.get(i)});
        }

        for (String[] s : process) {
            if (s[0].equals(String.valueOf(max))) {
                result.add(s[1]);
            }
        }
        String[] array = result.toArray(String[]::new);
        String join = String.join(", ", array);
        message.printWinner(join);

    }
}
