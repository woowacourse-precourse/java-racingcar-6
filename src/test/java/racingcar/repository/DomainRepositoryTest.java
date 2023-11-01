package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.TryCount;

@DisplayName("도메인 저장소 객체에")
class DomainRepositoryTest {

    private final DomainRepository<TryCount> tryCountRepository = new DomainRepository<>();

    @Test
    @DisplayName("저장 후 조회 요청시 null이 아닌 값을 반환하는가")
    void saveAndGet() {
        // given
        // when
        tryCountRepository.save(new TryCount(1));
        final TryCount tryCount = tryCountRepository.get();

        assertThat(tryCount).isNotNull();
    }

    @Test
    @DisplayName("저장이 안된 상태에서 조회 요청시 예외를 던지는가")
    void getWhenNull() {
        // given
        // when
        // then
        assertThatThrownBy(tryCountRepository::get).isInstanceOf(IllegalStateException.class);
    }
}
