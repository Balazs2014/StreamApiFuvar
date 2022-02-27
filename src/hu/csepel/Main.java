package hu.csepel;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Fuvarok fuvarok = new Fuvarok("fuvar.csv");

       // System.out.println(fuvarok);

        System.out.println(String.format("1. feladat: %d db", fuvarok.getDarab()));
        System.out.println(String.format("2. feladat:\n\tbevétel: $%.2f\n\tfuvarok száma: %d db", fuvarok.getBevetel(6185), fuvarok.getFuvarSzama(6185)));
        System.out.println(String.format("3. feladat: Összes megtett mérföld: %.2f", fuvarok.getOsszMerfold()));
        System.out.println(String.format("4. feladat: Leghosszabb fuvar adatai:\n\t%s", fuvarok.getLeghosszabbFuvar()));
        System.out.println(String.format("5. feladat: Legtöbb borravalót kapott fuvar adatai:\n\t%s", fuvarok.getLegtobbBorravaloFuvar()));
        System.out.println(String.format("6. feladat: 4261-es azonosítójú taxis megtett távolsága kilométerben: %.2f km", fuvarok.getHanyKilometer(4261)));
        System.out.println(String.format("7. feladat: Hibás sorok:\n\ta) száma: %d db\n\tb) összes időtartama: %d mp\n\tc) teljes bevétel: $%.2f",
                fuvarok.getHibasSorokSzama(), fuvarok.getHibasSorokUtazasIdotartama(), fuvarok.getHibasSorokTeljesBevetele()));
        System.out.println(String.format("8. feladat: %s\t",
                fuvarok.isSzerepelE(1452) ? "1452-es azonosítójú taxis szerepel az adatok között." : "1452-es azonosítójú taxis nem szerepel az adatok között."));
        System.out.println("9. feladat: A 3 időben legrövidebb utazás adatai:");
        for (Fuvar fuvar : fuvarok.getLegrovidebbFuvarok()) {
            System.out.println("\t" + fuvar);
        }
        System.out.println(String.format("10. feladat: December 24.-én %d darab fuvar volt.", fuvarok.getHanyFuvarIdopont("12-24")));
    }
}
