public class Sach {
    public static int cnt = 10000;
    private int maSach;
    private String tenSach, tacGia, nganh;
    private int nam;

    public Sach() {
    }

    public Sach(String tenSach, String tacGia, String nganh, int nam) {
        this.maSach = cnt++;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nganh = nganh;
        this.nam = nam;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    @Override
    public String toString() {
        return maSach + " " + tenSach + " " + tacGia + " " + nganh + " " + nam;
    }
}
