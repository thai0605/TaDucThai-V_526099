import java.util.Scanner;
class Diem2D {
    protected double x, y;

    // Ham khoi tao
    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Tinh khoang cach giua hai diem
    public double khoangCach(Diem2D p) {
        return Math.sqrt(
            Math.pow(x - p.x, 2) +
            Math.pow(y - p.y, 2)
        );
    }

    // Tim diem doi xung qua goc toa do
    public Diem2D doiXung() {
        return new Diem2D(-x, -y);
    }

    // Tinh tien diem
    public Diem2D tinhTien(double dx, double dy) {
        return new Diem2D(x + dx, y + dy);
    }

    // Hien thi toa do
    public void hienThi() {
        System.out.printf("(%.2f, %.2f)", x, y);
    }
}

// Chuong trinh kiem tra Bai 2.1
public class Bai2_1 {
    public static void main(String[] args) {

        Diem2D A = new Diem2D(3, 4);
        Diem2D B = new Diem2D(6, 8);

        System.out.print("Diem A: ");
        A.hienThi();

        System.out.print("\nDiem B: ");
        B.hienThi();

        System.out.println("\nKhoang cach AB: "
                + A.khoangCach(B));

        System.out.print("Diem doi xung cua A: ");
        A.doiXung().hienThi();

        System.out.print("\nDiem A sau khi tinh tien: ");
        A.tinhTien(2, 3).hienThi();
    }
}
