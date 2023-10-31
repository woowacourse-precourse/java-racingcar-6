## 1. 기능 구현 목록

- [ ] 자동차 이름 입력
  - [x] 입력 문구 출력
  - [x] 이름 입력
  - [x] 입력 값 검증 
    - [x] 이름은 쉼표(,)를 기준으로 구분한다.
    - [x] 각 이름은 5자 이하만 가능
    - [x] 중복된 이름이 존재하는지 검증
    - [x] 빈 값이 존재하는지 검증
    - [x] null 인지 검증
    - [x] 잘못된 값을 입력할 경우, IllegalArgumentException 발생 후 종료 
- [x] 총 이동 횟수 입력
  - [x] 입력 문구 출력
  - [x] 횟수 입력
  - [x] 입력 값 검증
    - [x] 양의 정수만 가능
    - [x] 잘못된 값을 입력할 경우, IllegalArgumentException 발생 후 종료
- [x] 결과 출력
  - [x] 실행 결과 문구 출력
  - [x] 각 자동차의 이름과 이동 결과 출력
  - [x] 전진 조건은 0 ~ 9 사이의 무작위 값을 구한 값이 4이상일 경우이다.
- [x] 최종 우승자 출력
  - [x] 우승자는 한 명이상일 수 있다.  
  - [x] 여러 명일 경우 쉼표(,)를 이용하여 구분한다.     
     

## 2. MVC 기능 분리
### Controller
* GameController - 레이스 시작과 종료
* RacingController - 레이스 진행

### Model
* Car - 자동차의 이름(String), 전진 횟수(Int) 저장

### View
* InputView - 입력
* OutputView - 출력
     
## 3. 패키지 구조
```bash
com.woowacourse.java-racingcar-6
┃ common
┃ ┣ ErrorMessageConstants.java
┃ ┣ StringToListConverter.java
┃ ┗ Validator.java
┃
┣ controller
┃ ┣ GameController.java
┃ ┗ RacingController.java
┃
┣ model
┃ ┗ Car.java
┃
┣ view
┃ ┣ InputView.java
┃ ┗ OutputView.java
```

## 4. Git 커밋 컨벤션
```
type: subject
```

### Commit Type
* feat: 새로운 기능 추가 
* fix: 버그 수정 
* docs: 문서 수정 
* refactor: 코드 리팩토링 
* test: 테스트 코드, 리팩토링 테스트 코드 추가 
* style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우

### Subject
* 50자를 넘기지 않고, 마침표를 붙이지 않습니다.
* 과거 시제를 사용하지 않고 명령어로 작성합니다.


## 5. Java 코드 컨벤션
https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java#java-style-guide