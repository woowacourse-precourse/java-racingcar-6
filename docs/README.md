# 미션: 자동차 경주 게임

## Introduction(고려 사항)

* `MVC` 아키텍처를 적용하고, `TDD` 개발을 시도할 것.
* 커밋 메시지를 자세하게 쓰려고 노력할 것.
* 최대한 `API를 잘 쓰는 아름다운`코드를 작성하려고 노력할 것.
* 객체지향 원칙을 잘 지키는 코드를 짜려고 노력할 것.

# 애플리케이션 흐름

1. 자동차 이름 요청 (print, input 포함)
2. 시도 횟수 요청 (print, input 포함)
3. 레이싱 시작
    1. 각 차수 실행 (doAttempt)
        1. 각 차 별로 랜덤 숫자 받기
        2. 조건에 따라 작으면 정지, 크면 전진
    2. 각 차수별 실행 결과 출력 (render, print)
4. 레이싱 종료, 우승자 출력 (print)

# 클래스 설계

## Model

### Race

* 책임
    * `Car`의 제어
    * Random 전진 로직
    * 우승자 판별 로직
* 기능
    * 레이스 수행
    * 각 `Car`에 대한 전진
    * 우승자 판별
    * 랜덤 전진 여부 판단 로직
* 테스트
    * 일반적인 레이스 생성, 실행, 결과 출력이 올바른지
    * 2인 이상의 우승자가 올바르게 처리되는지

### Car

* 책임
    * 전진 거리를 attribute로 가짐
    * 전진 기능
* 기능
    * 전진(update)
    * 전진 거리(get)
* 테스트
    * 차가 올바르게 전진하고, 전진 거리를 처리하는지

## View

### GameView

* 책임
    * 레이스 시작 전 출력 및 입력받기
* 기능
    * 이름들을 입력받아 Controller로 넘김
    * 시도 횟수를 입력받아 Controller로 넘김
* 테스트
    * 이름들 입력 테스트
        * 올바른 입력, 성공적인 파싱까지 확인
        * 너무 긴 이름 입력, `IllegalArgumentException` 확인
        * 빈 문자열 입력, `IllegalArgumentException` 확인
        * 올바르지 않은 형식(쉼표 문제) 입력, `IllegalArgumentException` 확인
    * 시도 횟수 입력 테스트
        * 올바른 숫자, 성공적인 파싱까지 확인
        * 음수 입력, `IllegalArgumentException` 확인
        * 숫자가 아닌 형식 입력, `IllegalArgumentException` 확인

### RaceView

* 책임
    * 레이스 시작 후 출력
    * `Race` 상태 렌더링
* 기능
    * `Race` 전체 렌더링 및 출력
    * 개별 `Car` 렌더링
* 테스트
    * 개별 `Car`의 올바른 렌더링 여부
    * 전체 `Race`의 올바른 렌더링 여부

### InputHandler

* 책임
    * Get, Validate, Parse, Wrap 수행
* 기능
    * 일련의 과정 수행

### InputValidator

* 인터페이스
    * `validate()`

#### CarNamesValidator

* 책임
    * 자동차 이름 검증
* 기능
    * 입력 검증, 실패 시 `IllegalArgumentException`
        * 쉼표 기준 나눔, 각 이름 5자 이하

#### NumberAttemptsValidator

* 책임
    * 시도 횟수 검증
* 기능
    * 입력 검증, 실패 시 `IllegalArgumentException`
        * 숫자, 0 이상

### InputParser

* 인터페이스
    * `parse()`

#### CarNamesParser

* 책임
    * 자동차 이름 파싱, wrapping
* 기능
    * 파싱 후 record로 wrapping

#### NumberAttemptsParser

* 책임
    * 시도 횟수 파싱, wrapping
* 기능
    * 파싱 후 record로 wrapping

## Controller

### GameController

* 책임
    * 게임 전반의 흐름을 제어함
    * View, Model을 연결함
* 기능
    * 게임 전체 흐름 제어
    * 입력받은 차가 추가된 레이스 생성
    * Model의 상태를 View에서 출력하도록 구성
* 테스트
    * ApplicationTest로 대체 

### DTO(들)

* `CarNamesDTO`
    * `ArrayList<String>`
* `RaceArgumentsDTO`
    * `int`

# 이슈

## 네이밍 정책

* method는 verb-noun 스타일로, class는 noun으로.
* 축약 금지.

### 용어 통일

* game: 입력, 레이스, 우승자 표시까지 포함하는 게임 전반
* race: 입력 이후 시작되는 레이스에 해당
* attempt: 시도

## 책임 관련

### InputHandler는 View인가 Controller인가

* 규칙: 공통의 것은 View가, 사람마다 다른 것은 Controller가.
* 결론: View가 InputHandler를 가짐.

### 어디까지가 Magic Literal, Magic Number일까?

### Race 도중의 상태를 중간에 view로 보낼 수 있나?

* Observer pattern을 쓰는 방식이 있긴 하다.
* 다만 그렇게 하면 좀 그렇다(Model의 의존 금지 위배)
* `doAttempts`같은 method를 `isFinished`와 함께 사용하면 반복해도 됨

### 그건 그렇고, attempts를 Race가 가지고 있는 건 옳나?

* Race가 가지게 되면 getter와 setter가 우후죽순 생기는 문제가 있다
* Controller가 횟수 로직을 들고 있어도 충분할듯 함.