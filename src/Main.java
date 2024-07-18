import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static BanDoc[] banDocs = new BanDoc[100];
    private static Sach[] sachs = new Sach[100];
    private static QLMuonSach[] qlMuonSachs = new QLMuonSach[100];
    private static int cntBanDoc = 0;
    private static int cntSach = 0;
    private static int cntQlMuonSach = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Thêm sách mới.");
            System.out.println("2. Thêm bạn đọc mới.");
            System.out.println("3. Lập bảng quản lý mượn sách.");
            System.out.println("4. Sắp xếp danh sách quản lý mượn sách theo tên bạn đọc.");
            System.out.println("5. Sắp xếp danh sách quản lý mượn sách theo số lượng cuốn sách được mượn giảm dần.");
            System.out.println("6. Tìm kếm danh sách mượn sách theo tên bạn đọc.");
            System.out.println("0. Thoát.");

            int q = Integer.parseInt(sc.nextLine());
            switch (q) {
                case 1:
                    themSach();
                    inDanhSach();
                    break;
                case 2:
                    themBanDoc();
                    inDanhSachBanDoc();
                    break;
                case 3:
                    lapBangQLMuonSach();
                    inBangQLMuonSach();
                    break;
                case 4:
                    sapXepTheoTenBD();
                    break;
                case 5:
                    sapXepTheoSoLuong();
                    break;
                case 6:
                    timKiemTheoTenBD();
                    break;
                case 0:
                    System.out.println("Kết thúc!");
                    return;
                default:
                    System.out.println("Vui lòng nhập lại!");
            }
        }
    }

    private static void themSach() {
        System.out.print("Nhập số lượng sách mới: ");
        int slSachMoi = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < slSachMoi; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1));
            System.out.print("Tên sách: ");
            String tenSach = sc.nextLine();
            System.out.print("Tên tác giả: ");
            String tacGia = sc.nextLine();
            System.out.print("Nhập chuyên ngành: ");
            String nganh = sc.nextLine();
            System.out.print("Nhập năm xuất bản: ");
            int nam = Integer.parseInt(sc.nextLine());
            sachs[cntSach++] = new Sach(tenSach, tacGia, nganh, nam);
        }
    }

    private static void inDanhSach() {
        System.out.println("Danh sách các đầu sách: ");
        for (int i = 0; i < cntSach; i++) {
            System.out.println(sachs[i]);
        }
    }

    private static void themBanDoc() {
        System.out.print("Nhập số lượng bạn đọc mới: ");
        int slBanDocMoi = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < slBanDocMoi; i++) {
            System.out.println("Nhập thông tin bạn đọc thứ " + (i + 1));
            System.out.print("Tên bạn đọc: ");
            String tenBanDoc = sc.nextLine();
            System.out.print("Địa chỉ: ");
            String dchi = sc.nextLine();
            System.out.print("Số điện thoại: ");
            String sdt = sc.nextLine();
            System.out.print("Loại bạn đọc: ");
            String loai = sc.nextLine();
            banDocs[cntBanDoc++] = new BanDoc(tenBanDoc, dchi, sdt, loai);
        }
    }

    private static void inDanhSachBanDoc() {
        System.out.println("Danh sách bạn đọc:");
        for (int i = 0; i < cntBanDoc; i++) {
            System.out.println(banDocs[i]);
        }
    }

    private static void lapBangQLMuonSach() {
        System.out.print("Nhập mã bạn đọc: ");
        int maBD = Integer.parseInt(sc.nextLine());
        BanDoc banDoc = null;
        for (int i = 0; i < cntBanDoc; i++) {
            if (banDocs[i].getMaBD() == maBD) {
                banDoc = banDocs[i];
                break;
            }
        }
        if (banDoc == null) {
            System.out.println("Không tìm thấy bạn đọc!");
            return;
        }

        QLMuonSach qlMuonSach = new QLMuonSach(banDoc);
        qlMuonSachs[cntQlMuonSach++] = qlMuonSach;

        System.out.print("Nhập số lượng sách muốn mượn: ");
        int slSach = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < slSach; i++) {
            System.out.print("Nhập mã sách: ");
            int maSach = Integer.parseInt(sc.nextLine());
            Sach sach = null;
            for (int j = 0; j < cntSach; j++) {
                if (sachs[j].getMaSach() == maSach) {
                    sach = sachs[j];
                }
            }
            if (sach==null) {
                System.out.println("Không tìm thấy sách!");
                continue;
            }
            System.out.print("Nhập số lượng cần mượn: ");
            int sl = Integer.parseInt(sc.nextLine());
            boolean muon = qlMuonSach.muonSach(sach, sl);
            if (muon) {
                System.out.println("Mượn sách thành công!");
            } else {
                System.out.println("Không thể mượn số lượng sách này!");
            }
        }

    }

    private static void inBangQLMuonSach() {
        System.out.println("Bảng quản lý mượn sách: ");
        for (int i = 0; i < cntQlMuonSach; i++) {
            System.out.println(qlMuonSachs[i]);
        }
    }

    private static void sapXepTheoTenBD() {
        for (int i = 0; i < qlMuonSachs.length-1; i++) {
            for (int j = i+1; j < qlMuonSachs.length; j++) {
                if (qlMuonSachs[i].getBanDoc().getTen().compareToIgnoreCase(qlMuonSachs[j].getBanDoc().getTen()) > 0) {
                    QLMuonSach tmp = qlMuonSachs[i];
                    qlMuonSachs[i] = qlMuonSachs[j];
                    qlMuonSachs[j] = tmp;
                }
            }
        }
        inBangQLMuonSach();
    }

    private static int tong(QLMuonSach qlMuonSach) {
        int total = 0;
        for (int x : qlMuonSach.getSl()) {
            total += x;
        }
        return total;
    }

    private static void sapXepTheoSoLuong() {
        for (int i = 0; i < qlMuonSachs.length-1; i++) {
            for (int j = i+1; j < qlMuonSachs.length; j++) {
                if (tong(qlMuonSachs[i]) < tong(qlMuonSachs[j])) {
                    QLMuonSach tmp = qlMuonSachs[i];
                    qlMuonSachs[i] = qlMuonSachs[j];
                    qlMuonSachs[j] = tmp;
                }
            }
        }
        inBangQLMuonSach();
    }

    private static void timKiemTheoTenBD() {
        System.out.print("Nhập tên bạn đọc muốn tìm: ");
        String name = sc.nextLine();
        int ok = 0;
        for (int i = 0; i < cntQlMuonSach; i++) {
            if (qlMuonSachs[i].getBanDoc().getTen().equalsIgnoreCase(name)) ok = 1;
        }
        if (ok == 0) System.out.println("Không có kết quả!");
        else {
            for (int i = 0; i < cntQlMuonSach; i++) {
                if (qlMuonSachs[i].getBanDoc().getTen().equalsIgnoreCase(name))
                    System.out.println(qlMuonSachs[i]);
            }
        }
    }

}