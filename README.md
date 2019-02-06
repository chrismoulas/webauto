<H1>Description</H1>
<h3>Simple framework for web site Testing and reporting</h3><br>
<ul> to compile and build: </ul>
<i>mvn clean install -DskipTests dependency:copy-dependencies assembly:single </i> <br>
<ul>execute the jar as : </ul> 
<i>java -jar xxx.jar -run "pathtosuitefile"</i> <br>
<ul>You can also execute as maven : </ul> 
<i>mvn clean install -DsuiteXmlFile=Suites.xml </i>
    
     
