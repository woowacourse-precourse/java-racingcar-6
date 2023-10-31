<h2>자동차 경주 게임</h2>

초간단 자동차 경주 게임을 구현하는 프로젝트 입니다.


<h3>📌 Skill</h3>

Java 1.8


<h3>자동차 경주 게임이란?</h3>

0부터 9의 무작위 값을 생성하고 무작위 값이 4 이상일 경우 자동차는 한 칸 전진합니다.
사용자에게 ,(쉼표)로 구분된 자동차 이름과 시도 횟수를 입력받은 뒤 게임은 시작됩니다.
시도할 횟수가 지나면 최종 우승자(다수 우승 가능성 있음)를 출력합니다.


<h3>🚀 기능 목록</h3>

- 사용자의 입력을 받아 저장
  - 자동차 이름을 받아 파싱해 객체에 저장
  - 시도할 횟수를 저장
  - 잘못된 값을 입력할 경우 예외처리 후 재입력
    - null값 입력할 경우 예외처리
    - 자동차이름 글자수 제한 예외처리
    - 자동차이름 공백포함 예외처리
    - 자동차이름 중복 예외처리
    - 시도횟수 입력 형식 예외처리
- 이동 가능한 포지션의 car객체 생성
- 무작위 값 추출
- 무작위 값 전진여부 판단
- 시도 횟수별 자동차 포지션 score 계산
- 종료 후 우승자 판단
  - 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다.


<h3>💡 사용법</h3>

**프로젝트 클론 :**

git clone https://github.com/ehdwoKIM/java-racingcar-6.git


**'ehdwokim' branch로 이동 :**

git checkout ehdwokim


**Application 실행 :**

package racingcar;
import racingcar.controller.Controller;

public class Application {
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.run();
	}
}


<h3>⌨️ 입력</h3>

**경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분) :**

<div>pobi,woni,jun</div>

**시도 횟수 :**

5


<h3>🖥 출력</h3>

**각 차수별 실행 결과 :**

pobi : --
woni : ----
jun : ---
단독 우승자 안내 문구
최종 우승자 : pobi
공동 우승자 안내 문구
최종 우승자 : pobi, jun


<h3>💻 사용 예시</h3>

경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)

pobi,woni,jun

시도할 회수는 몇회인가요?

5

실행 결과

pobi : -

woni : 

jun : -


pobi : --

woni : -

jun : --


pobi : ---

woni : --

jun : ---


pobi : ----

woni : ---

jun : ----


pobi : -----

woni : ----

jun : -----

최종 우승자 : pobi, jun
