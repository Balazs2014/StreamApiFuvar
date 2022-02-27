package hu.csepel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fuvarok {
    private List<Fuvar> fuvarList;

    public Fuvarok(String fileName) {
        fuvarList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            reader.readLine();
            String sor = reader.readLine();
            while (sor != null) {
                fuvarList.add(new Fuvar(sor));
                sor = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Fuvar fuvar : fuvarList) {
            s += fuvar + "\n";
        }
        return s;
    }
}
