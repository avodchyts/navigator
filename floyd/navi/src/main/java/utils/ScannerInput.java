package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScannerInput {
    BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));

    public String strInput() throws IOException {
        return strIn.readLine();
    }

    public int intInput() throws IOException {
        return Integer.parseInt(strIn.readLine());
    }

    public void closeSession () throws IOException {
        strIn.close();
    }
}
