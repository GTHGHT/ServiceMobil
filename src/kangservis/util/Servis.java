package kangservis.util;

public class Servis {
    private String idService = "";
    private String namaService = "";
    private String harga = "";

    public Servis(String idService, String namaService, String harga) {
        this.idService = idService;
        this.namaService = namaService;
        this.harga = harga;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNamaService() {
        return namaService;
    }

    public void setNamaService(String namaService) {
        this.namaService = namaService;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

}
