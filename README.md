## 핵심
- [ ] mvc 패턴을 적용
- [ ] 다형성을 인터페이스와 구현을 분리
- [ ] 의존성 주입
- [ ] 메소드별 테스트

## 기능 구현 
- [ ] 자동차의 정보를 담고 있는 Car Entity
- [ ] Car의 Repository
- [ ] Car의 Service
- [ ] 화면을 담당하는 View
- [ ] 게임 진행 순서를 담당하는 Controller
- [ ] 입력값의 Validation
- [ ] 의존성 주입용 Configuration
- [ ] 애플리케이션에서 사용되는 상수값과 메시지를 통합 관리

## Car Entity
1. 자동차의 정보(id, name, distance)를 담고 있는 Entity 객체
2. getter, setter 메소드만 소유

## CarRepository <- CarRepositoryImpl
1. Car Entity에 관한 Create, Read, Update을 담당하는 계층
2. 다형성을 위해 인터페이스 분리

## CarService <- CarServiceImpl
1. Controller 와 Repository 사이에서 데이터를 처리하는 계층
2. Controller 에서 특정 값 조회 및 수정시 요청시 Repository 에서 값을 가져와 데이터 처리 및 전송하는 역할
3. 다형성을 위해 인터페이스 분리

## View <- TerminalView
1. 터미널 환경에서 작동되는 View 클래스 구현
2. 입력과 출력을 담당하는 계층
3. 입력과 출력 메소드는 Controller 에서 호출
4. 다형성을 위해 인터페이스 분리

## GameController
1. GameConfig 에 의해 생성
2. 필드는 Configure 파일에서 의존성 주입 형태로 관리
3. 데이터 입력 메소드 호출
4. 게임 진행 로직 진행
5. 게임 결과 메소드 진행

## GameConfig(Configuration)
1. Service, Repository 의 구현체를 설정
2. main 메소드에서 생성되며 run()호출
3. GameController 에 의존성 주입 

## Constant
1. constant 패키지에서 통합관리
2. Message, Value 상수 값 관리