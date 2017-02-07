# Simple Web Crawler
1. Installing System Software:
  * Install Java JDK  "1.8.0_65" or higher version
  * Install maven 3.3.3 or higher version
  * Install Eclipse Neon.2 Release (4.6.2) or any other IDE compatible with Java 1.8 version
  * Install git bash version 1.9.5.msysgit.0  or higher version
2. Installing Simple Web Crawler
   * On local machine create a directory say c:\dev\test-bot
   * Use command git clone https://github.com/adidas2016/web-crawler.git
   * This should create directories say c:\dev\test-bot\web-crawler\web-bot. 
   * Go to c:\dev\test-bot\web-crawler\web-bot and type mvn clean install
   * This will download all the relevent libs, compile code, run tests and create executable jar file.
   * Go to target directory i.e c:\dev\test-bot\web-crawler\web-bot\target and run the command: java -jar web-bot-0.1.0-SNAPSHOT-shaded.jar
   * This should connect to a default web site, which is configured in properties fle and list all the raw sub domain urls and refined urls
3. View Source Code in Eclipse IDE 
  * From command line go to src code directory say c:\dev\test-bot\web-crawler\web-bot
  * Run command mvn eclipse:eclipse
  * Open Eclipse IDE
    * Open click on File -> Import -> Existing Projects Into Workspace -> Browse -> select the src code folder (say c:\dev\test-bot\web-crawler\web-bot)
 
 
 

 
