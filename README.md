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
   * This should connect to a default web site, which is configured in properties file and list all the raw sub domain urls and refined urls
3. View Source Code in Eclipse IDE 
  * From command line go to src code directory say c:\dev\test-bot\web-crawler\web-bot
  * Run command mvn eclipse:eclipse
  * Open Eclipse IDE
    * Open click on File -> Import -> Existing Projects Into Workspace -> Browse -> select the src code folder (say c:\dev\test-bot\web-crawler\web-bot)
  * Open WebCrawlerApp.java this is the Main class. Right click and Run as java Application to run the code from IDE.
  * Open config.properties file to change the url to point to another site. Note only one site should be enabled the other sites should be commented out. 
  
4. Reasoning and trade offs
   
   * Most commercial sites are blocked for Robots and Crawler Bot does not connect. Could have used open source frameworks which could eliminated this restriction.
   * Sub domain url patterns differ form site to site. Need to find better pattern matching to refine and clean raw urls.
   * Parallel threads to connect to sub domains and gets sub doamin lists. 
   * For Site map developed custom Node Tree Repository to save data. Could have used javax DOM to write and save to xml file. 
   
5. Explanation of what could be done with more time
   * Should have written more Junit / Mockito tests. Wanted to use more fluent assertions with AssertJ test framework.
   * Better pattern matching to refine and clean raw urls.
   * Add time out to http connection, to prevent any network delays and blocking.
   * Use java 8 CompletableFuture to run parallel threads in asnychronous and non blocking way to get sub domain urls.
   * Recursively call the sub domain urls.
   * Could have used javax DOM to write and save to xml file.
   * Although the code is written in self explainatory way. There are places where code comments needs to be added.
 

 
