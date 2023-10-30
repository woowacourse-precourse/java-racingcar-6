package racingcar.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Racer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryRacerRepository repository = new MemoryRacerRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
//    @Test
//    public void save(){
//        Racer racer = new Racer();
//        racer.setRacerName("tester1");
//
//        repository.save(racer);
//
//        Racer result = repository.findById(racer.getName()).get();
//        assertThat(racer).isEqualTo(result);
//    }

    @Test
    public void findByName(){
        Racer racer1 = new Racer();
        racer1.setRacerName("Spring1");
        repository.save(racer1);

        Racer racer2 = new Racer();
        racer2.setRacerName("Spring2");
        repository.save(racer1);

        Racer result = repository.findByName("Spring1").get();
        assertThat(result).isEqualTo(racer1);
    }

}
