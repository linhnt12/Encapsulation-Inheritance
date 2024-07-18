import java.util.Arrays;

public class QLMuonSach {
    private BanDoc banDoc;
    private Sach[] sachMuon;
    private int[] sl;
    private int slMuon;

    public QLMuonSach (BanDoc banDoc) {
        this.banDoc = banDoc;
        this.sachMuon = new Sach[5];
        this.sl = new int[5];
        this.slMuon = 0;
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public Sach[] getSachMuon() {
        return sachMuon;
    }

    public int[] getSl() {
        return sl;
    }

    public boolean muonSach (Sach sach, int slMoiSach) {
        if (slMuon > 5 || slMoiSach > 3) return false;

        for (int i=0; i<slMuon; i++) {
            if (sachMuon[i].getMaSach() == sach.getMaSach()) {
                if (sl[i] + slMoiSach > 3) return false;
                else {
                    sl[i] += slMoiSach;
                    return true;
                }
            }
        }

        sachMuon[slMuon] = sach;
        sl[slMuon] = slMoiSach;
        slMuon++;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Danh sách sách bạn đọc " + banDoc.getTen() + " đã mượn:\n");
        for (int i=0; i<slMuon; i++) {
            sb.append("Tên sách: ").append(sachMuon[i].getTenSach()).append("; Số lượng: ").append(sl[i]).append("\n");
        }
        return sb.toString();

    }
}
