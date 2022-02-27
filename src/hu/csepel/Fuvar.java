package hu.csepel;

public class Fuvar {
    private int taxiAzonosito;
    private String indulasIdopont;
    private int utazasIdotartam;
    private double megtettTavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetesMod;

    public Fuvar(String s) {
        String[] data = s.split(";");
        this.taxiAzonosito = Integer.parseInt(data[0]);
        this.indulasIdopont = data[1];
        this.utazasIdotartam = Integer.parseInt(data[2]);
        this.megtettTavolsag = Double.parseDouble(data[3].replace(",", "."));
        this.viteldij = Double.parseDouble(data[4].replace(",", "."));
        this.borravalo = Double.parseDouble(data[5].replace(",", "."));
        this.fizetesMod = data[6];
    }

    public int getTaxiAzonosito() {
        return taxiAzonosito;
    }

    public void setTaxiAzonosito(int taxiAzonosito) {
        this.taxiAzonosito = taxiAzonosito;
    }

    public String getIndulasIdopont() {
        return indulasIdopont;
    }

    public void setIndulasIdopont(String indulasIdopont) {
        this.indulasIdopont = indulasIdopont;
    }

    public int getUtazasIdotartam() {
        return utazasIdotartam;
    }

    public void setUtazasIdotartam(int utazasIdotartam) {
        this.utazasIdotartam = utazasIdotartam;
    }

    public double getMegtettTavolsag() {
        return megtettTavolsag;
    }

    public void setMegtettTavolsag(double megtettTavolsag) {
        this.megtettTavolsag = megtettTavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public void setViteldij(double viteldij) {
        this.viteldij = viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public void setBorravalo(double borravalo) {
        this.borravalo = borravalo;
    }

    public String getFizetesMod() {
        return fizetesMod;
    }

    public void setFizetesMod(String fizetesMod) {
        this.fizetesMod = fizetesMod;
    }

    @Override
    public String toString() {
        return String.format("%-8d %-20s %10d mp %10.2f m %10.2f $ %10.2f $ %12s",
                taxiAzonosito, indulasIdopont, utazasIdotartam, megtettTavolsag, viteldij, borravalo, fizetesMod);
    }
}
