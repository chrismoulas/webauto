package tools;

import java.io.IOException;

public class CsvReaderTest {

    public static void main(String [] args) throws IOException {
        CsvReader csv= new CsvReader();
        csv.getdata();
        csv.showContent();
        String type = csv.getdata().get(1).get(0);
        System.out.println(type);
    }
}
