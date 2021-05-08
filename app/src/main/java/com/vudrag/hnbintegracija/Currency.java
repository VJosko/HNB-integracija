package com.vudrag.hnbintegracija;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "currency_table")
public class Currency {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @SerializedName("Broj tečajnice")
    private String brojTecajnice;
    @SerializedName("Datum primjene")
    private String datumPrimjene;
    @SerializedName("Država")
    private String drzava;
    @SerializedName("Šifra valute")
    private String sifraValute;
    @SerializedName("Valuta")
    private String valuta;
    @SerializedName("Jedinica")
    private int jedinica;
    @SerializedName("Kupovni za devize")
    private String kupovniZaDevize;
    @SerializedName("Srednji za devize")
    private String srednjiZaDevize;
    @SerializedName("Prodajni za devize")
    private String prodajniZaDevize;

    public String getBrojTecajnice() {
        return brojTecajnice;
    }

    public void setBrojTecajnice(String brojTecajnice) {
        this.brojTecajnice = brojTecajnice;
    }

    public String getDatumPrimjene() {
        return datumPrimjene;
    }

    public void setDatumPrimjene(String datumPrimjene) {
        this.datumPrimjene = datumPrimjene;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getSifraValute() {
        return sifraValute;
    }

    public void setSifraValute(String sifraValute) {
        this.sifraValute = sifraValute;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public int getJedinica() {
        return jedinica;
    }

    public void setJedinica(int jedinica) {
        this.jedinica = jedinica;
    }

    public String getKupovniZaDevize() {
        return kupovniZaDevize;
    }

    public void setKupovniZaDevize(String kupovniZaDevize) {
        this.kupovniZaDevize = kupovniZaDevize;
    }

    public String getSrednjiZaDevize() {
        return srednjiZaDevize;
    }

    public void setSrednjiZaDevize(String srednjiZaDevize) {
        this.srednjiZaDevize = srednjiZaDevize;
    }

    public String getProdajniZaDevize() {
        return prodajniZaDevize;
    }

    public void setProdajniZaDevize(String prodajniZaDevize) {
        this.prodajniZaDevize = prodajniZaDevize;
    }
}
