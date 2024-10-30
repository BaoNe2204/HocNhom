/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hocnhom;

/**
 *
 * @author admin
 */
import java.util.Scanner;

public class BMi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bận nhập cân nặng: ");
        double Can_Nag = sc.nextDouble();
        System.out.println("Mời bận nhập cân Chiều cao: ");
        double Chieu_cao = sc.nextDouble();
        double BMI = Can_Nag / (Chieu_cao * Chieu_cao);
        if(Chieu_cao ==0){
            System.out.println("Không thể tính");
        }
        if (BMI < 15) {
            System.out.println("Vóc dáng gầy trơ xương");
        } else if (BMI >= 15 && BMI < 16) {
            System.out.println("Vóc dáng gầy");
        } else if (BMI >= 18 && BMI < 18.5) {
            System.out.println("Vóc dáng hơi gầy");
        } else if (BMI >= 18.8 && BMI < 25) {
            System.out.println("Vóc dáng cân đối");
        } else if (BMI >= 25 && BMI < 30) {
            System.out.println("Vóc dáng hơi béo");
        } else if (BMI >= 30 && BMI < 35) {
            System.out.println("Vóc dáng béo");
        } else if (BMI >= 35) {
            System.out.println("Vóc dáng quá béo");
        } else if (BMI <= 0) {
            System.out.println("Không thể có người như zậy");
        }

    }

}
