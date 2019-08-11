# SpringStudy

# 사용 언어
  - Web : HTML/CSS/Javascript(Ajax,JQuery)
  - Java : Spring Framework , Mybatis
  - DB : Maria DB 

# Branch
  - DB : Branch_DB
  - Java : Branch_Java
  - Web : Branch_Web

# Word File
  - 기능 정의서 참조

# DB
  ### TABLE
    - USER_INFORMATION (PRIMARY KEY = ID_NUM,ID )
    - MENU (PRIMARY KEY = MENU_NUM)
    - POST (PRIMARY KEY = POST_NUM , FOREIGN KEY = ID_NUM, MENU_NUM )
    - COMMENT (PRIMARY KEY = COMMENT_NUM ,FOREIGN KEY = ID_NUM, POST_NUM)
  ### VIEW
    - USER_VIEW
    - EACH_MENU (MENU JOIN POST)
  ### QUERY
    - DB FILE
