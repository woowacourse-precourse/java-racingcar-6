package racingcar;

public class RacingCar {
    private String name;
    public RacingCar(String input_name) {
        if(!is_valid_input_name(input_name)){
            new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        this.name=input_name;
    }

    static boolean is_valid_input_name(String inputName) {
        return 0<inputName.length() && inputName.length()<6;
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name='" + name + '\'' +
                '}';
    }
}
