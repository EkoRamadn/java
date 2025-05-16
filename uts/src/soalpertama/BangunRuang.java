package soalpertama;

import java.text.DecimalFormat;
import animasi.*;

public class BangunRuang {
    private DecimalFormat df = new DecimalFormat("#.00");
    private double _volume, _luasPermukaan;

    // Constructor untuk Kubus
    public BangunRuang(int rusuk) {
        this._volume = Math.pow(rusuk, 3);
        this._luasPermukaan = 6 * Math.pow(rusuk, 2);
    }

    // Constructor untuk Balok
    public BangunRuang(double panjang, double lebar, double tinggi) {
        this._volume = (panjang * lebar * tinggi);
        this._luasPermukaan = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
    }

    // Constructor untuk Silinder
    public BangunRuang(double jari, double tinggi) {
        this._volume = Math.PI * Math.pow(jari, 2) * tinggi;
        this._luasPermukaan = 2 * Math.PI * jari * (jari + tinggi);
    }

    // Constructor untuk Bola
    public BangunRuang(double jari) {
        this._volume = (4.0 / 3) * Math.PI * Math.pow(jari, 3);
        this._luasPermukaan = 4 * Math.PI * Math.pow(jari, 2);
    }

    public double getVolume() {
        return this._volume;
    }

    public double getLuasPermukaan() {
        return this._luasPermukaan;
    }

    public void setVolume(double data) {
        this._volume = data;
    }

    public void setLuasPermukaan(double data) {
        this._luasPermukaan = data;
    }

    public void tampilVolume() {
        Animtext.charAnim("| Volume : " + df.format(getVolume()) + "(cm3)", 20);
    }

    public void tampilLuasPermukaan() {
        Animtext.charAnim("| Luas Permukaan : " + df.format(getLuasPermukaan()) + "(cm2)", 20);
    }

    public void tampil() {
        System.out.println("+------------------------------->");
        System.out.println("| Hasil:");
        tampilVolume();
        tampilLuasPermukaan();
        System.out.println("+------------------------------->");
    }
}
