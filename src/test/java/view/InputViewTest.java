package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void split_test() {
        String tempString = "jade,lily,json";
        String[] carNames = InputView.splitNames(tempString);

        String[] checkingNames = {"jade","lily","json"};
        Assertions.assertThat(carNames).isEqualTo(checkingNames);
    }

    @Test
    void 입력_시_예외처리(){
        String tempString = " ";
        org.junit.jupiter.api.Assertions.assertThrowsExactly(IllegalArgumentException.class,
                () -> {InputView.splitNames(tempString);
        });
    }
    @Test
    void 입력_후_예외처리1(){
        String namesWithComma = "jade,lily,asdfsda";

        org.junit.jupiter.api.Assertions.assertThrowsExactly(IllegalArgumentException.class,
                ()->{InputView.splitNames(namesWithComma);
        });
    }
    @Test
    void 입력_후_예외처리2(){
        String namesWithComma = "jade,lily,lily";
        org.junit.jupiter.api.Assertions.assertThrowsExactly(IllegalArgumentException.class,
                ()->{InputView.splitNames(namesWithComma);
                });
    }
    @Test
    void 입력_후_예외처리3(){
        String namesWithComma = "jade,lily,1";
        org.junit.jupiter.api.Assertions.assertThrowsExactly(IllegalArgumentException.class,
                ()->{InputView.splitNames(namesWithComma);
                });
    }

    @Test
    void 시도_횟수_입력(){
        String tryValue = "12";
        int numberOfTry = InputView.numberOfTry(tryValue);

        int checkingNumber = 12;
        Assertions.assertThat(numberOfTry).isEqualTo(checkingNumber);
    }
    @Test
    void 시도_횟수_예외처리1(){
        String tryValue = " ";
        org.junit.jupiter.api.Assertions.assertThrowsExactly(IllegalArgumentException.class,
                () ->{InputView.numberOfTry(tryValue);
        });
    }
    @Test
    void 시도_횟수_예외처리2(){
        String tryValue = "asdfa";
        org.junit.jupiter.api.Assertions.assertThrowsExactly(IllegalArgumentException.class,
                () ->{InputView.numberOfTry(tryValue);
                });
    }
}