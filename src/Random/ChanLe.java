/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Random;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Gia Bao
 */
public class ChanLe {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        int Chan = 0;
        int Le = 0;
        for (int i = 0; i <= 20; i++) {
            int Random = random.nextInt(100) + 1;
            if (Random % 2 == 0) {
                Chan++;
                evenNumbers.add(Random); // Thêm vào danh sách số chẵn

            } else {
                Le++;
                oddNumbers.add(Random); // Thêm vào danh sách số lẻ

            }
        }
        for (int i = Chan; i < 10; i++) {
            System.out.println(Chan + " ");

        }
        System.out.print("Các số chẵn: ");
        for (int num : evenNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // In ra các số lẻ
        System.out.print("Các số lẻ: ");
        for (int num : oddNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Số lượng số chẵn: " + Chan);
        System.out.println("Số lượng số lẻ: " + Le);
    }
}
