### Controller
<hr/>

- RaceController
  - 자동차 이름 입력
  - 경주 횟수 n 입력
  - 참여 자동차 목록 생성
    - List<Car>
  - n회 동안 경기 진행
    - 각 차수별 진행 결과 출력
  - 우승자 출력

### Model
<hr/>

- Car(DAO)
  - 자동차 이름
  - 전진 칸 수
  - getter, setter
- Cars (DAO)
  - List<String> 받아 List<Car> 멤버 변수 생성
  - getter 
- CarRace(DTO)
  - 무작위 값을 통해 앞으로 전진
    - List<Car> 단위로 전진 처리
  - 우승자 계산

### View
<hr/>

- RaceViewer
  - 자동차 이름 입력 뷰
  - 시도 횟수 입력 뷰
  - 각 차수별 진행 결과 출력
    - parameter: List<Car>
  - 최종 우승자 출력
    - parameter: 우승자 리스트

### Util
<hr/>

- Validator (정규식 시도 예정)
  - 잘못된 이름 처리
    - 5글자 이상의 이름
    - 문자 이외의 값 입력
    - 비어있는 경우
  - (같은 이름이 있는 경우)
  - 잘못된 시도 횟수
    - 숫자 이외의 값