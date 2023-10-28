# 🛠️ 1주차 피드백

✅ [프리코스 1주 차 웹 백엔드 피드백](https://docs.google.com/document/d/1cW2jE3UoaBDNvGJ_Uh9zgkZXisOVezkRiPNpZvVmW9w/edit)

✅ 커밋 메시지 의미있게 작성하기

✅ 이름을 통해 의미 드러나게 하기

✅ Java에서 재공하는 API 사용하기

✅ MVC 패턴 적용하기

✅ 긍정 조건을 이용해 분기 처리하기

✅ enum에 포맷 적용하기

✅ 팩토리 메서드 패턴 적용하기

✅ 접근 제어자 고민하기

✅ 입력값을 검증할 때 원하는 타입으로 변환해서 검증하지 말고 입력값 자체로 검증 해보기

✅ 깃으로 관리할 자원에 대해 고려해보기

✅ 일급 컬렉션 적용해보기


---

# 🚀 기능 요구사항

✅ 상황에 맞는 문구를 출력한다.
1. 게임 시작했을때
2. 현재 자동차들의 상황
3. 우승자 출력

✅ 자동차 이름들을 입력받는다.
1. `,`를 기준으로 자동차 이름을 나눈다.
2. 자동차 이름에 대한 검증을 한다.
    1. 올바른 길이를 가지고 있는지 검증한다.
    2. 이름에 공백이 들어가있는지 검증한다.
    3. 중복된 이름이 있는지 검증한다.

✅ 시도할 횟수를 입력받는다.
1. 문자열이 아닌지 검증한다.
2. 실수가 아닌지 검증한다.
3. 올바른 범위를 가지고 있는지 검증한다.

✅ 매번 현재 자동차들의 상태를 출력한다.

✅ 우승자를 출력한다.

✅ 검증실패시 `IllegalArgumentException`를 발생시키고 종료한다.

---

# 🎯프로그래밍 요구 사항

    ✔️ 제출 전 요구사항 만족하는지 확인하기

- [ ]  ✅ [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- [ ]  ✅ indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다
- [ ]  ✅ JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
---

# ✏️과제 진행 요구 사항

✅ 기능을 구현하기 전`docs/README.md`에 구현할 기능 목록을 정리해 추가한다.

✅ Git의 커밋 단위는 앞 단계에서`docs/README.md`에 정리한 기능 목록 단위로 추가한다.

✅ [커밋 메시지 컨벤션](https://velog.io/@outstandingboy/Git-%EC%BB%A4%EB%B0%8B-%EB%A9%94%EC%8B%9C%EC%A7%80-%EA%B7%9C%EC%95%BD-%EC%A0%95%EB%A6%AC-the-AngularJS-commit-conventions) 가이드를 참고해 커밋 메시지를 작성한다.

---

# 🧳기능 목록

    ✔️ 체크 리스트 기준으로 기능 구현하고 커밋하기
프로젝트
<br>     📦 패키지
<br>         📔 클래스
<br>             🔤 변수
<br>             📝 메서드

## 📦 도메인 - Domain

- [ ]  📔 자동차그룹 - CarGroup
   - [ ]  📝 생성자 - CarGroup
   - [ ]  📝 자동차 그룹 생성하기 - of
   - [ ]  📝 자동차 그룹의 크기 구하기 - findSize
   - [ ]  📝 들어온 순서로 자동차 검색하기 - findCarByOrder
- [ ]  📔 자동차 - Car
   - [ ]  📝 생성자 - Car
   - [ ]  📝 자동차 생성하기 - of
   - [ ]  📝 자동차 이름 조회하기 - findName
   - [ ]  📝 자동차 위치 조회하기 - findPostion
   - [ ]  📝 자동차의 위치 수정하기 - updatePosition
   
## 🧪 도메인 테스트 - Domain

- [ ]  📔 자동차그룹 - CarGroupTest
   - [ ]  📝 자동차 그룹 생성하기 테스트
   - [ ]  📝 자동차 그룹의 크기 구하기 테스트
   - [ ]  📝 들어온 순서로 자동차 검색하기 테스트
- [ ]  📔 자동차 - CarTest
   - [ ]  📝 자동차 객체 생성하기 테스트
   - [ ]  📝 자동차 이름 조회하기 테스트
   - [ ]  📝 자동차 초기 위치 조회하기 테스트
   - [ ]  📝 자동차 위치 수정하기 테스트

## 📦 검증 - Validator

- [ ]  📔 자동차 이름 검증 - CarNameValidator
    - [ ]  📝통합 검증하기
    - [ ]  📝자동차 이름 1글자 이상 5글자 이하인지 검증하기 - isValidLength
    - [ ]  📝 자동차 이름에 공백이 들어가 있는지 검증하기 - hasWhiteSpace
    - [ ]  📝 중복된 이름이 있는지 검증하기 - hasDuplicateName
- [ ]  📔 이동 횟수 검증 - RoundValidator
    - [ ]  📝통합 검증하기
    - [ ]  📝 문자열이 아닌지 검증하기 - isNotString
    - [ ]  📝 실수가 아닌지 검증하기 - isNotRealNumber
    - [ ]  📝 `1`이상의 정수인지 검증하기 - isValidRange
- [ ]  📔 자동차 이름 검증하는 기준값들 - CarNameValidationCriteria
- [ ]  📔 이동 횟수 검증하는 기준값들 - RoundValidationCriteria

## 🧪  검증 테스트- Validator

- [ ]  📔 자동차 이름 검증 - CarNameValidatorTest
   - [ ]  📝 통합 검증하기 테스트
   - [ ]  📝 자동차 이름 1글자 이상 5글자 이하인지 검증하기 테스트
   - [ ]  📝 자동차 이름에 공백이 들어가 있는지 검증하기 테스트
   - [ ]  📝 중복된 이름이 있는지 검증하기 테스트
- [ ]  📔 시도 횟수 검증 - RoundValidator Test
   - [ ]  📝 통합 검증하기 테스트
   - [ ]  📝 문자열이 아닌지 검증하기 테스트
   - [ ]  📝 실수가 아닌지 검증하기 테스트
   - [ ]  📝 `1`이상의 정수인지 검증하기 테스트

## 📦 게임 관리 - Controller

- [ ]  📔 게임 관리 - GameController
    - [ ]  📝 게임 시작 - startGame
      - `자동차 이름 입력 받기` 호출하기
      - `자동차 이름에 대해 전처리 하기` 호출하기
      - `시도할 횟수 입력 받기` 호출하기
      - `시도 횟수에 대한 전처리 하기`  호출하기
      - `게임 한판 진행하기` 이동 횟수만큼 호출하기
      - `차수 결과 출력하기` 자동차 대수만큼 호출 하기
      - `최종 우승자 출력하기` 호출 하기

## 🧪 게임 관리 테스트 - Controller

- [ ]  📔 게임 관리 - GameControllerTest
   - [ ]  📝 게임 시작 테스트 - startGame
      - 입력값에 따른 결과가 올바른지 테스트

## 📦 비즈니스 로직 - Model

- [ ]  📔 게임 모델 - GameModel
   - [ ] 📝 게임 한 판 진행하기 - playGameRound
   - [ ] 📝 이동 여부 판단해주기 - detremineMove
- [ ]  📔 자동차 모델 - CarModel
   - [ ]  🔤 자동차 이름 검증
   - [ ]  📝 자동차 이름에 대해 전처리 하기 - carNamePreProcess
   - [ ]  📝 `,`을 기준으로 자동차 이름 나누기 - divideCarNameByCriteria
- [ ]  📔 시도 횟수 모델 - NumberOfRoundModel
   - [ ]  🔤 시도횟수 검증
   - [ ]  📝 시도 횟수에 대한 전처리 하기

## 🧪 비즈니스 로직 테스트 - Model

- [ ]  📔 게임 모델 - GameModelTest
   - [ ]  📝 게임 한 판 진행하기 테스트
   - [ ]  📝 이동 여부 판단해주기 테스트
- [ ]  📔 자동차 모델 - CarModelTest
   - [ ]  📝 자동차 이름에 대해 전처리 하기 테스트
   - [ ]  📝 `,`을 기준으로 자동차 이름 나누기 테스트
- [ ]  📔 시도 횟수 모델 - NumberOfRoundModel
   - [ ]  📝 시도 횟수에 대한 전처리 하기 테스트

## 📦 입출력 출력 - View

- [ ]  📔 사용자 입력 - InputView
    - [ ]  📝 자동차 이름 입력받기 - getCarNames
    - [ ]  📝 시도할 횟수 입력받기 - getNumberOfRound
- [ ]  📔 결과 출력 - OutputView
    - [ ]  📝 차수 결과 출력하기 - showRoundResult
    - [ ]  📝 최종 우승자 출력하기 - showFinalWinner

## 🧪 입출력 - View

- [ ]  📔 사용자 입력 - InputViewTest
   - [ ]  📝 자동차 이름 입력받기 테스트
   - [ ]  📝 시도할 횟수 입력받기 테스트
- [ ]  📔 결과 출력 - OutputViewTest
   - [ ]  📝 차수 결과 출력하기 테스트
   - [ ]  📝 최종 우승자가 두명 이상 있을때 출력하기 - showFinalWinnerMoreThanTwo
   - [ ]  📝 최종 우승자가 한 명일때 출력하기 - showFinalWinner

## 📦 예외 처리 - Exception

- [ ]  📔 사용자 정의 예외 - GameException
   - [ ]  📔 CarNameException
   - [ ]  📔 RoundException
## 📦 문구 - Message

- [ ]  📔 문구 - GamePrompt
    - inputCarNamesMessage
    - inputRoundMessage
    - outputResultMessage
    - outputCarPositionMessage
    - outputFinalWinnerMessage
- [ ]  📔 자동차 이름 예외 - CarNameExceptionPrompt
    - lengthMessage
    - whiteSpaceMessage
    - duplicateMessage
- [ ]  📔 시도 횟수 예외 - RoundExceptionPrompt
    - stringPrompt
    - realNumberPrompt
    - rangePrompt