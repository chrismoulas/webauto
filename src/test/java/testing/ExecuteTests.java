package testing;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class ExecuteTests {
    private static final String EXECTOKEN="-run";
    private static List<String> suitefiles;
    /*
     * to compile and build:
     * mvn clean install -DskipTests dependency:copy-dependencies assembly:single
     *
     */

    public static void main (String [] args) {
       TestNG runner= new TestNG();
        suitefiles=new ArrayList<String>();
       checkarguments(args);
       //suitefiles.add("C:\\data\\workspace\\webauto\\Suites.xml");
       runner.setTestSuites(suitefiles);
       runner.run();
   }

   private static void checkarguments(String[] args) {

       for (int i = 0; i < args.length; i++) {
           if (args[i].equals(EXECTOKEN)) {
               if ((i + 1) < args.length) {
                   suitefiles.add(args[i+1]);
                   i = i + 1;
               } else {
                   System.out.println("ERROR: Parameter missing after " + EXECTOKEN);
               }
           }
       }
   }}
