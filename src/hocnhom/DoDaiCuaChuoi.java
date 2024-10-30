import java.util.Scanner;

public class DoDaiCuaChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 3 chuỗi liên tiếp cách nhau bởi dấu cách:");
        
        String a = sc.nextLine();
        String b = sc.nextLine();
        String c = sc.nextLine();

        int aint = a.length();
        int bint = b.length();
        int cint = c.length();
        int max = Math.max(aint, Math.max(bint, cint));

        if (aint == bint && bint == cint) {
            System.out.println("Ba chuỗi bằng nhau");
        } else if (aint == bint) {
            System.out.println("Chuỗi a và b bằng nhau: " + a + " " + b);
        } else if (aint == cint) {
            System.out.println("Chuỗi a và c bằng nhau: " + a + " " + c);
        } else if (bint == cint) {
            System.out.println("Chuỗi b và c bằng nhau: " + b + " " + c);
        } else {
            if (max == aint) {
                System.out.println("Chuỗi a dài nhất: " + a);
            } else if (max == bint) {
                System.out.println("Chuỗi b dài nhất: " + b);
            } else {
                System.out.println("Chuỗi c dài nhất: " + c);
            }
        }
        sc.close();
    }
}
