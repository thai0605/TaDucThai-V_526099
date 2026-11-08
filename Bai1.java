
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Lop Nguoi
class Nguoi {
    protected String hoten;
    protected int tuoi;

    // Ham nhap
    public void nhap(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        hoten = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        tuoi = Integer.parseInt(sc.nextLine());
    }

    // Ham xuat
    public void xuat() {
        System.out.printf("%-20s %-10d", hoten, tuoi);
    }
}

// Lop NhanVien ke thua lop Nguoi
class NhanVien extends Nguoi {
    private int snct;
    private double hsl;

    // Ham nhap
    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);

        System.out.print("Nhap so nam cong tac: ");
        snct = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap he so luong: ");
        hsl = Double.parseDouble(sc.nextLine());
    }

    // Tinh tien luong
    public double tinhTienLuong() {
        double lcb = 1500000;
        double phucap = 200000 * snct;

        return lcb * hsl + phucap;
    }

    // Ham xuat
    @Override
    public void xuat() {
        super.xuat();

        System.out.printf("%-15d %-15.2f %,15.0f VND%n",
                snct, hsl, tinhTienLuong());
    }

    // Getter
    public int getSnct() {
        return snct;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<NhanVien> ds = new ArrayList<>();

        // Nhap n nhan vien
        System.out.print("Nhap so luong nhan vien: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap nhan vien thu " + (i + 1));

            NhanVien nv = new NhanVien();
            nv.nhap(sc);

            ds.add(nv);
        }

        // Tim nhan vien co so nam cong tac nhieu nhat
        NhanVien max = ds.get(0);

        for (NhanVien nv : ds) {
            if (nv.getSnct() > max.getSnct()) {
                max = nv;
            }
        }

        System.out.println("\n===== NHAN VIEN CO SO NAM CONG TAC NHIEU NHAT =====");
        System.out.printf("%-20s %-10s %-15s %-15s %s%n",
                "Ho ten", "Tuoi", "So nam CT", "He so luong", "Tien luong");
        max.xuat();

        // Sap xep nhan vien theo tien luong giam dan
        Collections.sort(ds, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                return Double.compare(
                        nv2.tinhTienLuong(),
                        nv1.tinhTienLuong()
                );
            }
        });

        // In danh sach sau khi sap xep
        System.out.println("\n===== DANH SACH NHAN VIEN THEO LUONG GIAM DAN =====");

        System.out.printf("%-20s %-10s %-15s %-15s %s%n",
                "Ho ten", "Tuoi", "So nam CT", "He so luong", "Tien luong");

        for (NhanVien nv : ds) {
            nv.xuat();
        }

        sc.close();
    }
}
