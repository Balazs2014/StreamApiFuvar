package hu.csepel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    //1. Feladat
    public long getDarab() {
        return fuvarList.stream().count();
    }

    //2. Feladat
    public double getBevetel(int taxiAzonosito) {
        return fuvarList.stream()
                .filter(fuvar -> fuvar.getTaxiAzonosito() == taxiAzonosito)
                .mapToDouble(fuvar -> fuvar.getViteldij() + fuvar.getBorravalo())
                .sum();
    }


    public long getFuvarSzama(int taxiAzonosito) {
        return fuvarList.stream()
                .filter(fuvar -> fuvar.getTaxiAzonosito() == taxiAzonosito)
                .count();
    }

    //3. Feladat
    public double getOsszMerfold() {
        return fuvarList.stream()
                .mapToDouble(fuvar -> fuvar.getMegtettTavolsag())
                .sum();
    }


    //4. Feladat
    public Fuvar getLeghosszabbFuvar() {
        return fuvarList.stream()
                .max(Comparator.comparingInt(fuvar -> fuvar.getUtazasIdotartam()))
                .get();
    }

    //5. Feladat
    public Fuvar getLegtobbBorravaloFuvar() {
        return fuvarList.stream()
                .max(Comparator.comparingDouble(Fuvar::getBorravalo))
                .get();
    }

    //6. Feladat
    public double getHanyKilometer(int taxiAzonosito) {
        return fuvarList.stream()
                .filter(fuvar -> fuvar.getTaxiAzonosito() == taxiAzonosito)
                .mapToDouble(fuvar -> fuvar.getMegtettTavolsag() * 1.6)
                .sum();
    }

    //7. Feladat
    //a
    public long getHibasSorokSzama() {
        return fuvarList.stream()
                .filter(fuvar -> fuvar.getUtazasIdotartam() > 0 && fuvar.getViteldij() > 0 && fuvar.getMegtettTavolsag() == 0)
                .count();
    }

    //b
    public long getHibasSorokUtazasIdotartama() {
        return fuvarList.stream()
                .filter(fuvar -> fuvar.getUtazasIdotartam() > 0 && fuvar.getViteldij() > 0 && fuvar.getMegtettTavolsag() == 0)
                .mapToInt(fuvar -> fuvar.getUtazasIdotartam())
                .sum();
    }

    //c
    public double getHibasSorokTeljesBevetele() {
        return fuvarList.stream()
                .filter(fuvar -> fuvar.getUtazasIdotartam() > 0 && fuvar.getViteldij() > 0 && fuvar.getMegtettTavolsag() == 0)
                .mapToDouble(fuvar -> fuvar.getViteldij() + fuvar.getBorravalo())
                .sum();
    }

    //8. Feladat
    public boolean isSzerepelE(int taxiAzonosito) {
        return fuvarList.stream()
                .anyMatch(fuvar -> fuvar.getTaxiAzonosito() == taxiAzonosito);
    }

    //9. Feladat
    public List<Fuvar> getLegrovidebbFuvarok() {
        return fuvarList.stream()
                .filter(fuvar -> fuvar.getUtazasIdotartam() > 0)
                .sorted(Comparator.comparingInt(Fuvar::getUtazasIdotartam))
                .limit(3)
                .collect(Collectors.toList());
    }

    //10. Feladat
    public long getHanyFuvarIdopont(String indulasIdopont) {
        return fuvarList.stream()
                .filter(fuvar -> fuvar.getIndulasIdopont().contains(indulasIdopont))
                .count();
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
