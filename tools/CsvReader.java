package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {
    private static List<List<String>> records = new ArrayList<>();

public List<List<String>> getdata () throws IOException {
    //Get file from resources folder
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("test.csv").getFile());
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            records.add(Arrays.asList(values));
        }
    }
    return records;
}
public void showContent(){
    List<String> list=records.get(1);
    for(String l : list){
        System.out.println(l);
    }
}


}
