package soalkedua;

public class Pajak {
    String _vendor,_tipe;
    int _harga;

    Pajak(String vendor, String tipe, int harga) {
        this._vendor = vendor;
        this._tipe = tipe;
        this._harga = harga;
    }

    public String getVendor() {
        return this._vendor;
    }

    public void setVendor(String data){
        this._vendor = data;
    }

    public String getTipe(){
        return this._tipe;
    }

    public void setTipe(String data){
        this._tipe = data;
    }

    public int getHarga(){
        return this._harga;
    }

    public void setHarga(int data){
        this._harga = data;
    }
}
