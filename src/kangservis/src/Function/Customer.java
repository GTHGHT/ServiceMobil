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
public class Customer {
    private String idCustomer = "";
    private String namaCustomer = "";
    private String noHandphone = "";

    public Customer(String idCustomer, String namaCustomer, String noHandphone) {
        this.idCustomer = idCustomer;
        this.namaCustomer = namaCustomer;
        this.noHandphone = noHandphone;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(String noHandphone) {
        this.noHandphone = noHandphone;
    }
}
