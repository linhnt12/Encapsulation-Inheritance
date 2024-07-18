public class BanDoc {
    private static int cnt = 10000;
    private int maBD;
    private String ten, dchi, sdt, loaiBD;

    public BanDoc() {
    }

    public BanDoc(String ten, String dchi, String sdt, String loaiBD) {
        this.maBD = cnt++;
        this.ten = ten;
        this.dchi = dchi;
        this.sdt = sdt;
        this.loaiBD = loaiBD;
    }

    public int getMaBD() {
        return maBD;
    }

    public void setMaBD(int maBD) {
        this.maBD = maBD;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getLoaiBD() {
        return loaiBD;
    }

    public void setLoaiBD(String loaiBD) {
        this.loaiBD = loaiBD;
    }

    @Override
    public String toString() {
        return maBD + " " + ten + " " + dchi + " " + sdt + " " + loaiBD;
    }
}
