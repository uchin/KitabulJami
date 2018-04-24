package com.uchin.kitabuljami.utils;

/**
 * Created by Mukhlasin on 9/14/2017.
 */

public class Hadits {
    private int idHadits;
    private String noUrutHadits, judul, status;


    public Hadits(int idHadits, String noUrutHadits, String judul, String status) {
        this.idHadits = idHadits;
        this.noUrutHadits = noUrutHadits;
        this.judul = judul;
        this.status = status;
    }

    public int getIdHadits() {
        return idHadits;
    }

    public String getNoUrutHadits() {
        return noUrutHadits;
    }

    public String getJudul() {
        return judul;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hadits hadits = (Hadits) o;

        return idHadits == hadits.idHadits && noUrutHadits.equals(hadits.noUrutHadits) && judul.equals(hadits.judul) && status.equals(hadits.status);

    }

    @Override
    public int hashCode() {
        int result = idHadits;
        result = 31 * result + noUrutHadits.hashCode();
        result = 31 * result + judul.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Hadits{" +
                "idHadits=" + idHadits +
                ", noUrutHadits='" + noUrutHadits + '\'' +
                ", judul='" + judul + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
