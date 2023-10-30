# JUnit 학습 내용 정리

## 단위 테스트 코드 구조
- 정답은 없지만, 흔히 given-when-then 구조로 작성하는 추세
- given(준비): 특정 데이터가 주어지고
- when(실행): 특정 함수를 실행했을 때
- then(검증): 특정 결과가 도출되어야 한다.

```
    @Test
    void split_메서드로_주어진_값을_구분() {
        // given
        final User user = new User();
        final String input = "pobi,woni,jun";
        
        // when
        user.splitCarsName(input);

        // then
        assertThat(user.getCarsNameArray()).contains("pobi", "woni", "jun");
    }
```

## JUnit 실행 결과
- Pass: Assert문이 통과한 경우
- Fail: Assert문이 실패한 경우
- Error: 테스트 케이스 실행 시 예외가 발생한 경우

## Annotaion(어노테이션)
- 역할: 단위 테스트를 정의하고 관리함. 이를 위해 여러 어노테이션을 제공함.

## Annotation 종류
- @Test: 해당 메서드가 단위 테스트임을 명시함.
- @BeforeAll: 테스트가 시작되기 전, 딱 한 번만 실행함. 
- @AfterAll: 테스트가 끝난 후, 딱 한 번만 실행함.
- @BeforeEach: 각각의 테스트 메서드가 실행되기 전, 특정 메서드를 실행함.
- @AfterEach: 각각의 테스트 메서드가 실행된 후, 특정 메서드를 실행함.


- @Timeout: 주어진 시간 안에 테스트가 끝나지 않으면 실패함.
- @Disabled: 클래스 혹은 메서드 테스트를 비활성화함.
- @DisplayName: 테스트 클래스 혹은 메서드에 이름을 붙여주고 싶을 때 사용함.
- @DisplayNameGeneration: 클래스에 해당 어노테이션을 붙이면 
  @Test 메서드 이름에 언더바로 표시한 모든 부분은 공백으로 처리됨.
