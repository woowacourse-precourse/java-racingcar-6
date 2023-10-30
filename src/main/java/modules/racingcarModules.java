package modules;

public class racingcarModules {
    public static void checked_car_name_len(String[] carNames) {
        for (String carName : carNames) {
            racingcarException.exception_len_5(carName);
        }
    }
    public static int checked_random_num_over_4(int random_num) {
        if (random_num >= 4) {
            return 1;
        } else {
            return 0;
        }
    }
}
