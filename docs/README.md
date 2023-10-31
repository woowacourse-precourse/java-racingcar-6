# 미션 - 🚗 자동차 경주 🚗

---

## 💡 기능 요구 사항

특정 자동차들이 주어졌을 때, 랜덤하게 전지 혹은 멈추어 경주가 이뤄진다. 이 때, 가장 앞선 자동차를 우승자로 출력한다.

### 📝 **핵심 알고리즘 및 구현할 기능 요구사항**

1. 자동차 이름(5자 이하)과 시도할 횟수를 입력 받음
2. 시도할 횟수만큼 각각 자동차들이 랜덤한 거리 전진 혹은 멈춤
3. 우승자 출력, 여러명일 경우 쉼표로 구분하여 출력
- 잘못된 값 입력시 IllegalArgumentException 발생후 앱 종료

### 진행 방향

저번 프로젝트에서 TDD방식으로 프로젝트를 진행하였다.

해당 방법은 꼼꼼한 면이 좋았지만 그만큼 시간이 많이 들었다.

해당 부분을 개선하고자 이번 프로젝트에서는 BDD방식을 통해 코드를 작성할 것이다.

### 🗺️ BDD(Behavior Driven Development, 행위 주도 개발)

TDD에서 더 나아가 테스트 케이스 자체가 요구 사항이 되도록 하는 개발 방법이다.

시나리오 기반으로 테스트 케이스를 작성하여 함수 단위 테스트를 권장하지 않는다.

이번 프로젝트에서 Describe - Context - It패턴을 사용할 것이다.

> - Describe : 설명할 테스트 대상(테스트 대상이 되는 클래스, 메서드 이름 등)
> - Context : 테스트 대상이 놓인 상황(테스트할 메서드에 입력할 파라미터 등)
> - It : 테스트 대상의 행동(테스트 대상 메서드가 무엇을 리턴하는지 등)

이 방식을 통해 얻는 장점은 아래와 같다.

> 1. 테스트 코드가 계층적 구조 이룸
> 2. 테스트 코드 추가 혹은 읽을 때 범위만 신경쓰면 됨

BDD개발을 위해 시나리오를 아래와 같이 상세히 작성하였다.

- Describe : RaceService class
    - Describe : inputCars method
        - Context : with characters ranging from 1 to 5
            - It successfully return
        - Context : with charaters other than 1 to 5
            - It throw IllegalArgumentException
    - Describe : inputCnt method
        - Context : count is a positive number
            - It successfully return
        - Context : count is character
            - It throw IllegalArgumentException
    - Describe : raceStart method
        - It move cars and show cars and distance moved
    - Describe : showWinners method
        - It finds the car(s) with the longest distance, and if there are multiple, it prints all of them
- Describe : RaceController
    - Describe : run method
        - It start race

한글로 표현하면 아래와 같다.

- RaceService 클래스
    - inputCars 메서드는
        - 1이상 5이하의 차 이름이 주어진다면
            - 오류없이 리턴
        - 1이상 5이하의 차 이름을 갖지 않는다면
            - IllegalArgumentException 발생시킴
    - inputCnt 메서드는
        - 양수인 횟수가 주어진다면
            - 오류없이 리턴
        - 횟수가 음수가 주어진다면
            - IllegalArgumentException 발생시킴
    - raceStart는
        - 차를 이동시키고 결과를 보여줌
    - showWinner 메서드는
        - 가장 많이 이동한 자동차 출력, 만약 여러대일 경우 복수 출력
- RaceController 클래스
    - raceStart 메서드는
        - 레이스를 시작

참고로 해당 프로젝트의 프로그래밍 요구 사항에 indent depth가 2까지만 허용함으로 Describe같은 자잘한 부분은 생략했다.

---
## 👓 프로그래밍 요구 사항 정리

- 실행 환경 : JDK 17
- build.gradle 변경 및 외부 라이브러리 사용 불가
- Java 코드 컨벤션 가이드 준수
    - 들여쓰기 : +4 스페이스
    - 들여쓰기 지속 : 최소 +8 스페이스
    - 최대 열 : 120
- System.exit() 사용 금지, ApplicationTest 성공 필수
- 요구사항에서 달리 명시하지 않는 파일, 패키지 이름 수정 혹은 이동 불가
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용
- 3항 연산자 금지
- 함수는 한 가지 일만 하도록 최대한 최소화
- 테스트 메서드를 통해 정상 동작 테스트
- JDK에서 제공하는 Random 및 Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
    - ex : Randoms.pickNumberInRange(0,9);

---

## 💻 과제 진행 요구 사항

- 미션은 [java-racingcar-6](https://github.com/woowacourse-precourse/java-racingcar-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.