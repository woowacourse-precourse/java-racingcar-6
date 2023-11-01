
## 전체 기능 구현 체크리스트

- ✔️ 각 자동차의 이름과 반복 횟수를 사용자에게 입력받음
- ✔️ 입력값 검사 및 예외처리 (checkCarNames)
  - [x] 자동차 이름은 5글자 이하
  - [x] 자동차 이름은 콤마로 구분
  - [x] 반복회수는 숫자만 입력 가능   
- ✔️ 자동차의 이름과 위치를 하나의 객체로 표현 (Car.js)
- ✔️ 게임 진행 상황을 하나의 객체로 표현
- ✔️ 주어진 횟수에 맞게 반복 실행
- ✔️ 게임 진행 상황 출력

<br />

## 어플리케이션 구조
![img1 daumcdn](https://github.com/woowacourse-precourse/java-racingcar-6/assets/101636590/790907e5-9f69-4632-918d-b76195f398e9)

- Controller : 서비스 호출
- Service : 핵심 로직 구현
- Domain : 객체 구현
- Repository : 도메인 객체 저장 및 관리
- View: 사용자에게 보여지는 입출력



<br />

## 커밋메세지 컨벤션
- feat = 새로운 기능 추가
- fix = 버그 수정
- refactor = 리팩토리
- style = css, ui, design 변경
- comment = 주석
- docs = 문서 수정
- test = 테스트 관련
- rename / remove = 파일 이름 변경 / 삭제
