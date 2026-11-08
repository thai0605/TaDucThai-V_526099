import java.util.Scanner;
class Diem3D extends Diem2D {
    private double z;

    // Ham khoi tao
    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    // Tinh khoang cach giua hai diem 3D
    public double khoangCach3D(Diem3D p) {
        return Math.sqrt(
            Math.pow(x - p.x, 2) +
            Math.pow(y - p.y, 2) +
            Math.pow(z - p.z, 2)
        );
    }

    // Ghi de ham doi xung
    @Override
    public Diem3D doiXung() {
        return new Diem3D(-x, -y, -z);
    }

    // Tinh tien diem trong khong gian 3D
    public Diem3D tinhTien3D(double dx, double dy, double dz) {
        return new Diem3D(x + dx, y + dy, z + dz);
    }

    // Ghi de ham hien thi
    @Override
    public void hienThi() {
        System.out.printf("(%.2f, %.2f, %.2f)", x, y, z);
    }
}

// Chuong trinh kiem tra Bai 2.2
public class Bai2_2 {
    public static void main(String[] args) {

        Diem3D A = new Diem3D(1, 2, 3);
        Diem3D B = new Diem3D(4, 5, 6);

        System.out.print("Diem A: ");
        A.hienThi();

        System.out.print("\nDiem B: ");
        B.hienThi();

        System.out.println("\nKhoang cach AB: "
                + A.khoangCach3D(B));

        System.out.print("Diem doi xung cua A: ");
        A.doiXung().hienThi();

        System.out.print("\nDiem A sau khi tinh tien: ");
        A.tinhTien3D(2, 3, 4).hienThi();
    }
}
