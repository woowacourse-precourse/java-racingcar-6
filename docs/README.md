## 목표
- [x] 기능 단위로 커밋
- [x] 각 메소드별로 테스트 작성
- [ ] stream 사용 해 보기
- [x] 메소드명, 함수명 피드백 반영하기
- [x] 매직넘버 상수화 시키기
- [x] 기능 요구 사항 체크
  - 예외 처리 꼼꼼하게 확인하기.
  - 특히 입출력 요구 사항 중요! 
- [x] 프로그래밍 요구 사항 체크
  - Java 코드 컨벤션 확인
  - 인덴트 depth 2 이하로 유지
  - JUnit 7, AssertJ 이용해서 테스트 코드 작성
- [x] 과제 진행 요구 사항 체크
  - 기능 목록 단위로 커밋   
- [x] 프리코스 1주차 피드백 확인

## 기능 목록
1. 경주할 자동차 이름 입력
   - 입력 예외처리 with `IllegalArgumentException`
     - [x] 이름은 5자 이하인가?
     - [x] null이 아닌가?
     - [x] "" or " "이 아닌가?
2. 경주 횟수 입력
   - 입력 예외처리 with `IllegalArgumentException`
     - [x] 숫자로 변환 가능한가?
     - [x] 1 이상의 정수인가?
     - [x] null이 아닌가?
     - [x] "" or " "이 아닌가?
3. 자동차 이동 여부 계산
   - 각 자동차마다 `0 ~ 9` 사이 무작위 값 생성
     - `0 ~ 3` : 멈춤
     - `4 ~ 9` : 전진
4. 경주 결과 출력
   - 한번 전진할 때마다 `-` 출력
5. 3 ~ 4번 과정을 경주 횟수만큼 반복
6. 우승자 출력
   - 우승자는 여러명 가능
     - 단독 우승자 예시: `최종 우승자 : pobi`
     - 공동 우승자 예시: `최종 우승자 : pobi, jun`

## 클래스 목록
- `Application` : 게임 시작  
- `RacingController` : 게임 컨트롤러  
- `RacingService` : 레이싱 진행에 사용되는 메소드를 갖는 클래스
- 📂 *constant*
  - `CarStatus` : 이동, 중지 enum
  - `MagicNumber` : 요구사항 관련 매직넘버 enum
  - `Message` : 출력 문구 enum
  - `SymbolType` : "," 와 " : " 와 같은 기호 enum
- 📂 *Entity*
  - `Car` : 자동차 이름, 자동차 경로, 자동차 이동 횟수를 필드로 갖는 클래스
- 📂 *util*
  - `Calculation` : 자동차 이동 관련 메소드를 갖는 클래스
  - `ConsolePrint` : 콘솔창 출력 관련 메소드를 갖는 클래스
  - `Exception` : 입력 예외처리
  - `Parsing` : 입력 String 파싱

