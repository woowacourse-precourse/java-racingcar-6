package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UnitTest {
    game test = new game();

    @Test
    void 이름_분리() {
        String name_bundle = "abc,def,ghi";
        String[] names = test.input_name(name_bundle);
        assertThat(names).containsExactly("abc", "def", "ghi");
    }

    @Test
    void 무작위수_비교(){
        boolean result;

        for(int i = 0; i < 10; i++) {
            result = test.check_num(i);
            if(i < 4) {
                assertThat(result).isFalse();
            }
            else {
                assertThat(result).isTrue();
            }
        }
    }

    @Test
    void 자동차_움직임_결정(){
        car test_car = new car("test", 0);
        boolean test_result;

        test_result = true;
        test.car_move(test_car, test_result);
        assertThat(test_car.position).isEqualTo(1);

        test_result = false;
        test.car_move(test_car, test_result);
        assertThat(test_car.position).isEqualTo(1);
    }

    @Test
    void 최댓값_확인1() {
        car[] test_car = new car[6];

        test.max_stacks = new car[6];
        test.top = -1;

        for (int i = 0; i < 6; i++) {
            test_car[i] = new car("test" + i, i);
        }

        for (int i = 0; i < 6; i++) {
            test.find_max(test_car[i]);
        }

        assertThat(test.max_stacks).contains(test_car[5]);
    }

    @Test
    void 최댓값_확인2() {
        car[] test_car = new car[6];

        test.max_stacks = new car[6];
        test.top = -1;

        for (int i = 0; i < 6; i++) {
            test_car[i] = new car("test" + i, 1);
        }

        for (int i = 0; i < 6; i++) {
            test.find_max(test_car[i]);
        }



        assertThat(test.max_stacks).contains(test_car[0], test_car[1], test_car[2], test_car[3],
                test_car[4], test_car[5]);
    }

    @Test
    void 최댓값_확인3() {
        car[] test_car = new car[6];

        test.max_stacks = new car[6];
        test.top = -1;

        for(int i = 0; i < 6; i = i + 2) {
            test_car[i] = new car("test" + i, 1);
        }
        for(int i = 1; i < 6; i = i + 2){
            test_car[i] = new car("test" + i, 2);
        }
        for(int i = 0; i < 6; i++) {
            test.find_max(test_car[i]);
        }

        assertThat(test.max_stacks).contains(test_car[1], test_car[3], test_car[5]);
    }
}
