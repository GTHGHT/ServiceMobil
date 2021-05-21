/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

/**
 *
 * @author muham
 */
public class Mobil {
    private String idCustomer = "";
    private String namaMobil = "";

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getPlatMobil() {
        return platMobil;
    }

    public void setPlatMobil(String platMobil) {
        this.platMobil = platMobil;
    }
    private String platMobil = "";
    
    public Mobil(String idCustomer, String namaMobil, String platMobil){
        this.idCustomer = idCustomer;
        this.namaMobil = namaMobil;
        this.platMobil = platMobil;
    }
}
