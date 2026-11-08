
import java.util.ArrayList;
import java.util.Scanner;

public class Bai2_3 {

    // Tinh tong khoang cach cac diem 2D
    public static double tongKhoangCach2D(ArrayList<Diem2D> ds) {
        double tong = 0;

        for (int i = 0; i < ds.size() - 1; i++) {
            tong += ds.get(i).khoangCach(ds.get(i + 1));
        }

        return tong;
    }

    // Tinh tong khoang cach cac diem 3D
    public static double tongKhoangCach3D(ArrayList<Diem3D> ds) {
        double tong = 0;

        for (int i = 0; i < ds.size() - 1; i++) {
            tong += ds.get(i).khoangCach3D(ds.get(i + 1));
        }

        return tong;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Diem2D> ds2D = new ArrayList<>();
        ArrayList<Diem3D> ds3D = new ArrayList<>();

        // Danh sach chung chua diem 2D va 3D
        ArrayList<Diem2D> dsTatCa = new ArrayList<>();

        // Nhap danh sach diem 2D
        System.out.print("Nhap so luong diem 2D: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap diem 2D thu " + (i + 1));

            System.out.print("Nhap x: ");
            double x = sc.nextDouble();

            System.out.print("Nhap y: ");
            double y = sc.nextDouble();

            Diem2D p = new Diem2D(x, y);

            ds2D.add(p);
            dsTatCa.add(p);
        }

        // Nhap danh sach diem 3D
        System.out.print("\nNhap so luong diem 3D: ");
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            System.out.println("Nhap diem 3D thu " + (i + 1));

            System.out.print("Nhap x: ");
            double x = sc.nextDouble();

            System.out.print("Nhap y: ");
            double y = sc.nextDouble();

            System.out.print("Nhap z: ");
            double z = sc.nextDouble();

            Diem3D p = new Diem3D(x, y, z);

            ds3D.add(p);
            dsTatCa.add(p);
        }

        // Tinh tong khoang cach diem 2D va 3D
        System.out.println("\n===== TONG KHOANG CACH =====");

        System.out.println("Tong khoang cach 2D: "
                + tongKhoangCach2D(ds2D));

        System.out.println("Tong khoang cach 3D: "
                + tongKhoangCach3D(ds3D));

        // Them cac diem doi xung vao danh sach chung
        for (Diem2D p : ds2D) {
            dsTatCa.add(p.doiXung());
        }

        for (Diem3D p : ds3D) {
            dsTatCa.add(p.doiXung());
        }

        // Hien thi danh sach diem
        System.out.println("\n===== DANH SACH TAT CA CAC DIEM =====");

        for (int i = 0; i < dsTatCa.size(); i++) {

            System.out.print("Diem " + (i + 1) + ": ");

            Diem2D p = dsTatCa.get(i);

            if (p instanceof Diem3D) {
                System.out.print("3D: ");
            } else {
                System.out.print("2D: ");
            }

            p.hienThi();

            System.out.println();
        }

        sc.close();
    }
}
