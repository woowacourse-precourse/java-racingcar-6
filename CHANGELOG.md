#### 2023-10-31

##### Refactors

* **validator:**
    * edit validateInputCount() method (ee63fd77)

##### Tests

* **game:**
    * update game test (e65ce732)
* **output:**
    * append output test case (c5d5e631)

#### 2023-10-30

##### Tests

* **output:**
    * update output test (26b5f79c)
* **validator:**
    * update validator test (6ae16e4e)
* **input:**
    * update input test (1b0fdf7e)
* **car:**
    * update car test (ad1d191d)

#### 2023-10-29

##### Documentation Changes

* **README:**
    * edit Validator description (7e3281d8)
    * add description for Validator class (2a2a4f5c)

##### New Features

* **validator:**
    * add Validator class (e239c182)
* **config:**
    * add Configuration class (5da2aaad)

##### Refactors

* **validator:**
    * change Validator to enable customization (9f3b0cf4)
* **game:**
    * change method name (5ecf237e)

#### 2023-10-28

##### Documentation Changes

* **README:**
    * change output function list (3e39ee5c)

##### New Features

* **game:**
    * add Game class (f5173615)
* **output:**
    * implement printWinner() (ff773c1f)
    * implement printExecutionResult() (a8cfbd42)
    * add ConsoleOutput to implement Output (3cee179a)
    * add Output interface (3eb94c20)

##### Refactors

* **constant:**
    * change constant class to enum (2d1cb920)
    * change class name (bdcbd208)
* **game:**
    * change magic number to constant (2dcf02c5)
* **input:**
    * edit method (543fe747)
    * optimize stream (00d91a38)
* **car:**
    * change magic number to constant (663c6f51)
* **output:**
    * edit printWinner() method (75b3fe59)
    * integrate print method to printText() (00cb7808)

##### Tests

* **game:**
    * add play() test (93ca8926)
* **output:**
    * add printWinner() test (3e220224)
    * add printExecutionResult() test (395b83ce)

#### 2023-10-27

##### Documentation Changes

* **README:**
    * change input exception (c7f1e398)

##### New Features

* **input:**
    * implement receiveTotalCountOfExecution() (4f67b391)
    * add ConsoleInput to implement Input (1077cbbc)
    * add Input interface (e564f432)
* **output:**
    * implement printWinner() (ff773c1f)
    * implement printExecutionResult() (a8cfbd42)
    * add ConsoleOutput to implement Output (3cee179a)
    * add Output interface (3eb94c20)

##### Tests

* **input:**
    * add exception case (3a383db9)
    * add receiveTotalCountOfExecution() test (ac7cfe68)
    * add receiveCarNamesAndMakeList() test (3a08ff0f)

#### 2023-10-26

##### Documentation Changes

* **README:**
    * add function list to implement (80695020)

##### New Features

* **car:**
    * add moveForward() method (4223eebe)
    * add Car class (d479c048)

##### Tests

* **car:**
    * add moveForward() test (b8c6ac53)
