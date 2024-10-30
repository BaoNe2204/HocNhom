/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calendar;

import java.util.Calendar;

/**
 *
 * @author admin
 */
public class NgayHienTai {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int Day = calendar.get(Calendar.DAY_OF_MONTH);
        int Month = calendar.get(Calendar.MONTH) + 1;//bắt đàu từ số 0 nên phải cộng 1
        int Year = calendar.get(Calendar.YEAR);
        System.out.printf("Ngày Hiện tại là: %02d/%02d/%d%n", Day, Month, Year);
        System.out.println("Ngày Hiện tại là: "+Day+"/"+Month+"/"+Year);
    }

}
