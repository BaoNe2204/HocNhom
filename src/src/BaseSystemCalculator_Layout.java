package src;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class BaseSystemCalculator_Layout extends JFrame {

    private JButton BtCalculate, BtReset_Layout_Two;
    private JButton BtConvert, BtReset_Layout_One;
    private JTextField Number_One_Layout_Two, Number_Two_Layout_Two, ketQuaField_Layout_Two;
    private JTextField Number_One_Layout_One, ketQuaField_Layout_One;
    private JComboBox<String> Operation;
    private JLabel lblCalculate, lblBanQuyen, lblChuyenDoi;
    private JTextField Current_Base_System, Target_Radix_System;
    private JTextField First_Radix_System, Second_Base_System, Result_Radix_System;
    ConvertNumber convertNumber = new ConvertNumber();

    private final String FirstColorCode = "#243642";
    private final String SecondColorCode = "#387478";
    private final String ThirdColorCode = "#629584";
    private final String FourthColorCode = "#E2F1E7";

    Font fontBigSize = new Font("arial", Font.BOLD, 32);
    Font fontSmallSize = new Font("arial", Font.BOLD, 16);

    public BaseSystemCalculator_Layout(String title) {
        this.setTitle(title);
        addControls();
        addEvents();
        URL imageUrl = getClass().getResource("/resources/Logo-icon.png");
        ImageIcon icon = new ImageIcon(imageUrl);
        Image image = icon.getImage();
        setIconImage(image);
    }

    private void addControls() {
        addControls_Layout_One();
        addControls_Layout_Two();
        addControls_Layout_Menu();
    }

    private void addControls_Layout_Menu() {
        Container container = getContentPane();
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        JPanel panel1 = addControls_Layout_One();
        JPanel panel2 = addControls_Layout_Two();

        cardPanel.add(panel1, "Panel 1");
        cardPanel.add(panel2, "Panel 2");

        container.add(cardPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton button1 = new JButton("CHUYỂN ĐỔI");
        JButton button2 = new JButton("TÍNH TOÁN");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        container.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setBounds(0, 0, 550, 60);

        buttonPanel.setPreferredSize(new Dimension(550, 60));
        container.add(buttonPanel, BorderLayout.NORTH);
        container.add(cardPanel, BorderLayout.CENTER);

        cardLayout.show(cardPanel, "Panel 1");
        updateButtonColors(button1, button2, "Panel 1");

        button1.addActionListener(e -> {
            cardLayout.show(cardPanel, "Panel 1");
            updateButtonColors(button1, button2, "Panel 1");
        });
        button2.addActionListener(e -> {
            cardLayout.show(cardPanel, "Panel 2");
            updateButtonColors(button1, button2, "Panel 2");
        });
    }

    private JPanel addControls_Layout_One() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.WHITE);

        lblChuyenDoi = new JLabel("CHUYỂN ĐỔI HỆ CƠ SỐ");
        lblChuyenDoi.setFont(fontBigSize);
        lblChuyenDoi.setForeground(Color.decode(SecondColorCode));
        lblChuyenDoi.setBounds(90, 10, 400, 50);
        panel1.add(lblChuyenDoi);

        Number_One_Layout_One = new JTextField(30);
        Number_One_Layout_One = createPlaceholderTextField("SỐ CẦN CHUYỂN");
        Number_One_Layout_One.setBounds(20, 80, 320, 40);
        panel1.add(Number_One_Layout_One);

        Current_Base_System = new JTextField();
        Current_Base_System = createPlaceholderTextField("2-36");
        createLabel(panel1, "HỆ CƠ SỐ HIỆN TẠI", 100, 130);
        Current_Base_System.setBounds(20, 130, 70, 30);
        Current_Base_System.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.add(Current_Base_System);

        Target_Radix_System = new JTextField();
        Target_Radix_System = createPlaceholderTextField("2-36");
        createLabel(panel1, "HỆ CƠ SỐ CẦN CHUYỂN", 100, 170);
        Target_Radix_System.setBounds(20, 170, 70, 30);
        Target_Radix_System.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.add(Target_Radix_System);

        ketQuaField_Layout_One = new JTextField();
        ketQuaField_Layout_One = createPlaceholderTextField("KẾT QUẢ CHUYỂN ĐỔI");
        ketQuaField_Layout_One.setBounds(20, 210, 320, 40);
        ketQuaField_Layout_One.setEditable(false);
        ketQuaField_Layout_One.setFont(new Font("Arial", Font.BOLD, 19));
        panel1.add(ketQuaField_Layout_One);

        JSeparator separator1 = new JSeparator();
        separator1.setBounds(0, 260, 550, 2);
        panel1.add(separator1);

        BtConvert = new JButton("Chuyển đổi");
        BtConvert.setBounds(100, 280, 130, 30);
        BtConvert.setBackground(Color.decode(SecondColorCode));
        BtConvert.setForeground(Color.WHITE);
        BtConvert.setFont(fontSmallSize);
        BtConvert.setFocusPainted(false);
        panel1.add(BtConvert);

        BtReset_Layout_One = new JButton("Đặt Lại");
        BtReset_Layout_One.setBounds(320, 280, 130, 30);
        BtReset_Layout_One.setBackground(Color.decode(SecondColorCode));
        BtReset_Layout_One.setForeground(Color.WHITE);
        BtReset_Layout_One.setFont(fontSmallSize);
        BtReset_Layout_One.setFocusPainted(false);
        panel1.add(BtReset_Layout_One);

        lblBanQuyen = new JLabel("PHẦN MỀM ĐƯỢC VIẾT BỞI DLP TEAM");
        lblBanQuyen.setFont(fontSmallSize);
        lblBanQuyen.setForeground(Color.BLACK);
        lblBanQuyen.setBounds(120, 500, 550, 130);
        panel1.add(lblBanQuyen);
        add(panel1);

        try {
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/resources/Logo-DLP.png"));
            Image originalImage = originalIcon.getImage();

            int originalWidth = originalImage.getWidth(null);
            int originalHeight = originalImage.getHeight(null);

            int newWidth = 250;
            int newHeight = (originalHeight * newWidth) / originalWidth;

            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JLabel logoLabel = new JLabel(scaledIcon);
            logoLabel.setBounds(150, 330, newWidth, newHeight);
            panel1.add(logoLabel);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể tải hình ảnh: " + e.getMessage());
        }

        return panel1;

    }

    private JPanel addControls_Layout_Two() {
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.WHITE);
        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        lblCalculate = new JLabel("MÁY TÍNH HỆ CƠ SỐ");
        lblCalculate.setFont(fontBigSize);
        lblCalculate.setForeground(Color.decode(SecondColorCode));
        lblCalculate.setBounds(110, 10, 400, 50);
        panel2.add(lblCalculate);

        Number_One_Layout_Two = new JTextField();
        Number_One_Layout_Two = createPlaceholderTextField("SỐ THỨ NHẤT");
        Number_One_Layout_Two.setBounds(130, 60, 320, 40);
        panel2.add(Number_One_Layout_Two);

        First_Radix_System = new JTextField(3);
        First_Radix_System = createPlaceholderTextField("2-36");
        createLabel(panel2, "HỆ CƠ SỐ SỐ ĐẦU TIÊN", 240, 110);
        First_Radix_System.setBounds(380, 110, 70, 30);
        First_Radix_System.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(First_Radix_System);

        Operation = new JComboBox<>(new String[]{"+", "-", "x", ":"});
        createLabel(panel2, "CHỌN PHÉP TÍNH", 210, 150);
        Operation.setBounds(130, 150, 70, 30);
        Operation.setRenderer(renderer);
        Operation.setBackground(Color.decode(FourthColorCode));
        panel2.add(Operation);

        Number_Two_Layout_Two = new JTextField();
        Number_Two_Layout_Two = createPlaceholderTextField("SỐ THỨ HAI");
        Number_Two_Layout_Two.setBounds(130, 235, 320, 40);
        panel2.add(Number_Two_Layout_Two);

        Second_Base_System = new JTextField(3);
        createLabel(panel2, "HỆ CƠ SỐ SỐ THỨ HAI", 240, 190);
        Second_Base_System = createPlaceholderTextField("2-36");
        Second_Base_System.setBounds(380, 190, 70, 30);
        Second_Base_System.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(Second_Base_System);

        Result_Radix_System = new JTextField(3);
        createLabel(panel2, "HỆ CƠ SỐ KẾT QUẢ", 240, 290);
        Result_Radix_System = createPlaceholderTextField("2-36");
        Result_Radix_System.setBounds(380, 290, 70, 30);
        Result_Radix_System.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(Result_Radix_System);

        ketQuaField_Layout_Two = new JTextField();
        ketQuaField_Layout_Two = createPlaceholderTextField("KẾT QUẢ PHÉP TÍNH");
        ketQuaField_Layout_Two.setBounds(130, 340, 320, 40);
        ketQuaField_Layout_Two.setEditable(false);
        ketQuaField_Layout_Two.setFont(new Font("Arial", Font.BOLD, 19));
        panel2.add(ketQuaField_Layout_Two);

        BtCalculate = new JButton("Tính Toán");
        BtCalculate.setBounds(100, 390, 120, 30);
        BtCalculate.setBackground(Color.decode(SecondColorCode));
        BtCalculate.setForeground(Color.WHITE);
        BtCalculate.setFont(fontSmallSize);
        BtCalculate.setFocusPainted(false);
        panel2.add(BtCalculate);

        BtReset_Layout_Two = new JButton("Đặt Lại");
        BtReset_Layout_Two.setBounds(320, 390, 130, 30);
        BtReset_Layout_Two.setBackground(Color.decode(SecondColorCode));
        BtReset_Layout_Two.setForeground(Color.WHITE);
        BtReset_Layout_Two.setFont(fontSmallSize);
        BtReset_Layout_Two.setFocusPainted(false);
        panel2.add(BtReset_Layout_Two);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 283, 550, 2);
        panel2.add(separator);

        // Thêm logo
        try {

            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/resources/Logo-DLP.png"));
            Image originalImage = originalIcon.getImage();
            int originalWidth = originalImage.getWidth(null);
            int originalHeight = originalImage.getHeight(null);

            int newWidth = 170;
            int newHeight = (originalHeight * newWidth) / originalWidth;

            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JLabel logoLabel = new JLabel(scaledIcon);
            logoLabel.setBounds(200, 400, newWidth, newHeight);
            panel2.add(logoLabel);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể tải hình ảnh: " + e.getMessage());
        }

        lblBanQuyen = new JLabel("PHẦN MỀM ĐƯỢC VIẾT BỞI DLP TEAM");
        lblBanQuyen.setFont(fontSmallSize);
        lblBanQuyen.setForeground(Color.BLACK);
        lblBanQuyen.setBounds(120, 500, 550, 130);
        panel2.add(lblBanQuyen);
        add(panel2);
        return panel2;

    }

    private void updateButtonColors(JButton button1, JButton button2, String currentPanel) {
        if ("Panel 1".equals(currentPanel)) {
            button1.setBackground(Color.WHITE);
            button1.setFont(fontSmallSize);
            button1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            button1.setFocusPainted(false);
            button1.setForeground(Color.decode(ThirdColorCode));

            button2.setBackground(Color.decode(FourthColorCode));
            button2.setFont(fontSmallSize);
            button2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            button2.setFocusPainted(false);
            button2.setForeground(Color.decode(ThirdColorCode));

        } else if ("Panel 2".equals(currentPanel)) {
            button1.setBackground(Color.decode(FourthColorCode));
            button1.setFont(fontSmallSize);
            button1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            button1.setFocusPainted(false);
            button1.setForeground(Color.decode(ThirdColorCode));

            button2.setBackground(Color.WHITE);
            button2.setFont(fontSmallSize);
            button2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            button2.setForeground(Color.decode(ThirdColorCode));

        }
    }

    private JTextField createPlaceholderTextField(String placeholder) {
        PlaceholderTextField textField = new PlaceholderTextField(placeholder, fontSmallSize);
        textField.setBackground(Color.decode(FourthColorCode));
        return textField;
    }

    private void createLabel(JPanel panel, String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 400, 30);
        label.setForeground(Color.decode(SecondColorCode)); // Set the color of the text
        panel.add(label);
    }

private void addEvents() {
        // layout1
        BtReset_Layout_One.addActionListener(e -> resetFieldsLayoutOne());
        BtConvert.addActionListener(e -> {
            String numConvertText = Number_One_Layout_One.getText();
            if (numConvertText.contains(",")){
                numConvertText=numConvertText.replace(",",".");
            }
            String Current_Base_System_Text = Current_Base_System.getText();
            String Target_Radix_System_Text = Target_Radix_System.getText();

            if (numConvertText.equals("NHẬP SỐ CẦN CHUYỂN") || numConvertText.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int CurrentBaseSystem = Integer.parseInt(Current_Base_System_Text);
                int TargetRadixSystem = Integer.parseInt(Target_Radix_System_Text);

                if (CurrentBaseSystem < 2 || CurrentBaseSystem > 36 || TargetRadixSystem < 2
                        || TargetRadixSystem > 36) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị hợp lệ cho hệ cơ số (từ 2 đến 36).",
                            "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ketQuaField_Layout_One.setText((convertNumber.Convert(numConvertText, CurrentBaseSystem, TargetRadixSystem)));
                ketQuaField_Layout_One.setForeground(Color.black);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ trong hệ cơ số đã chọn!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        });

        // layout2
        BtReset_Layout_Two.addActionListener(e -> resetFieldsLayoutTwo());
        BtCalculate.addActionListener(e -> {
            String numOneText = Number_One_Layout_Two.getText();
            String numTwoText = Number_Two_Layout_Two.getText();
              if (numOneText.contains(",")){
                numOneText=numOneText.replace(",",".");
            }
            if (numTwoText.contains(",")){
                numTwoText=numTwoText.replace(",",".");
            }
            String firstRadixText = First_Radix_System.getText();
            String secondRadixText = Second_Base_System.getText();
            String resultRadixText = Result_Radix_System.getText();
            int operation = Operation.getSelectedIndex();

            if (numOneText.trim().isEmpty() || numTwoText.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Chuyển đổi hệ cơ số từ String sang int
                int firstRadix = Integer.parseInt(firstRadixText);
                int secondRadix = Integer.parseInt(secondRadixText);
                int resultRadix = Integer.parseInt(resultRadixText);

                if (firstRadix < 2 || firstRadix > 36 || secondRadix < 2 || secondRadix > 36 || resultRadix < 2
                        || resultRadix > 36) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị hợp lệ cho hệ cơ số (từ 2 đến 36).",
                            "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                String print_result = convertNumber.CalculatorConverNumber(numOneText, firstRadix, numTwoText, secondRadix, firstRadix, operation);

                ketQuaField_Layout_Two.setForeground(Color.BLACK);
                ketQuaField_Layout_Two.setText(print_result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ trong hệ cơ số đã chọn!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        });
    }
    private void resetFieldsLayoutOne() {
        if (Number_One_Layout_One instanceof PlaceholderTextField) {
            ((PlaceholderTextField) Number_One_Layout_One).reset();
        } else {
            Number_One_Layout_One.setText("");
        }

        Current_Base_System.setText("");
        Target_Radix_System.setText("");
        Current_Base_System.setText("2-36");
        Target_Radix_System.setText("2-36");
        ketQuaField_Layout_One.setText("KẾT QUẢ CHUYỂN ĐỔI");
        ketQuaField_Layout_One.setForeground(Color.GRAY);

        resetPlaceholder(Current_Base_System);
        resetPlaceholder(Target_Radix_System);

    }

    private void resetFieldsLayoutTwo() {
        Number_One_Layout_Two.setText("NHẬP SỐ THỨ NHẤT");
        Number_One_Layout_Two.setForeground(Color.GRAY);

        Number_Two_Layout_Two.setText("NHẬP SỐ THỨ HAI");
        Number_Two_Layout_Two.setForeground(Color.GRAY);

        ketQuaField_Layout_Two.setText("");
        First_Radix_System.setText("2-36");
        Second_Base_System.setText("2-36");
        Result_Radix_System.setText("2-36");

        Operation.setSelectedIndex(0);

        ketQuaField_Layout_Two.setText("SỐ ĐÃ THỰC HIỆN PHÉP TÍNH");
        ketQuaField_Layout_Two.setForeground(Color.GRAY);

        resetPlaceholder(Number_One_Layout_Two);
        resetPlaceholder(Number_Two_Layout_Two);
        resetPlaceholder(First_Radix_System);
        resetPlaceholder(Second_Base_System);
        resetPlaceholder(Result_Radix_System);
        resetPlaceholder(ketQuaField_Layout_Two);
    }

    private void resetPlaceholder(JTextField textField) {
        if (textField instanceof PlaceholderTextField) {
            PlaceholderTextField pf = (PlaceholderTextField) textField;
            pf.setText(pf.getPlaceholder());
            pf.setForeground(Color.GRAY);
        } else {
            textField.setText("");
        }
    }

    public void showWindow() {
        this.setSize(550, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        BaseSystemCalculator_Layout display = new BaseSystemCalculator_Layout("Máy Tinh Hệ Cơ Số");
        display.showWindow();
    }

   public static String Convert(String number, int fromBase, int toBase) {
        if (fromBase == 10) {
            return ConvertFormDecimal(number, toBase);
        } else {
            return ConvertFormDecimal(ConvertToDecimal(number, fromBase), toBase);
        }
    }
   public static String ConvertToDecimal(String number, int fromBase) {
        String result;
        if (number.contains(".") || number.contains(",")) {
            String[] numberSplit = number.split("[.,]");
            String numberSplit0 = ConvertIntegerToDec(numberSplit[0], fromBase);
            String numberSplit1 = ConvertDoubleToDec(numberSplit[1], fromBase);
            result = numberSplit0 + "." + numberSplit1;
            return result;
        } else {
            result = ConvertIntegerToDec(number, fromBase);
            return result;
        }

    }

    public static String ConvertDoubleToDec(String number, int fromBase) {
        char[] characterNumber = number.toCharArray();
        double sum = 0;
        int count = 1;
        for (int i = 0; i < characterNumber.length; i++) {
            sum += NumberChar(characterNumber[i]) * Math.pow(fromBase, -count);
            count++;
        }
        String result = String.valueOf(sum).substring(2);
        return result;
    }

    public static String ConvertIntegerToDec(String number, int fromBase) {
        int DecNum = Integer.parseInt(number, fromBase);
        String result = Integer.toString(DecNum, 10);
        return result;
    }

    public static String ConvertFormDecimal(String number, int toBase) {
        double numberInteger = Double.parseDouble(number);
        if (numberInteger % 1 == 0) {
            String result = ConvertInteger(String.valueOf((int) numberInteger), toBase);
            return result;
        } else {
            String result = "";
            String[] numberSplit = number.split("[.,]");
            String splitDouble = "0." + numberSplit[1];
            double convertDouble = Double.parseDouble(splitDouble);
            String resultInt = "";
            String resultDouble = "";
            resultInt = ConvertInteger(String.valueOf(numberSplit[0]), toBase);
            resultDouble = ConvertDouble(String.valueOf(convertDouble), toBase);
            result = resultInt + resultDouble;
            return result;
        }
    }

    public static String ConvertInteger(String number, int toBase) {
        StringBuilder result = new StringBuilder();

        String character;
        int characterInt;
        int numberInt = Integer.parseInt(number);
        while (numberInt > 0) {
            characterInt = numberInt % toBase;
            numberInt /= toBase;
            if (characterInt < 10) {
                character = String.valueOf(characterInt);
            } else {
                character = CharNumber(characterInt);
            }
            result.append(character);
        }
        return result.reverse().toString();
    }

    public static String ConvertDouble(String doubleNumber, int toBase) {
        StringBuilder result = new StringBuilder();
        result.insert(0, ".");
        int count = 4;
        int numberInt;
        double numberDouble = Double.parseDouble(doubleNumber);
        for (int i = 1; i <= count; i++) {
            numberInt = (int) (numberDouble * toBase);
            if (numberInt < 10) {
                result.append(String.valueOf(numberInt));
            } else {
                result.append(CharNumber(numberInt));
            }
            double calculator = numberDouble * toBase;
            String[] splitNumber = String.valueOf(calculator).split("[.,]");
            numberDouble = Double.parseDouble("0." + splitNumber[1]);
        }
        return result.toString();
    }

    public static String CharNumber(int n) {
        switch (n) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            case 16:
                return "G";
            case 17:
                return "H";
            case 18:
                return "I";
            case 19:
                return "J";
            case 20:
                return "K";
            case 21:
                return "L";
            case 22:
                return "M";
            case 23:
                return "N";
            case 24:
                return "O";
            case 25:
                return "P";
            case 26:
                return "Q";
            case 27:
                return "R";
            case 28:

                return "S";
            case 29:
                return "T";
            case 30:

                return "U";
            case 31:
                return "V";
            case 32:

                return "W";
            case 33:
                return "X";
            case 34:

                return "Y";
            case 35:
                return "Z";

        }
        return null;
    }

    public static int NumberChar(char n) {
        n = Character.toUpperCase(n);

        switch (n) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            case 'G':
                return 16;
            case 'H':
                return 17;
            case 'I':
                return 18;
            case 'J':
                return 19;
            case 'K':
                return 20;
            case 'L':
                return 21;
            case 'M':
                return 22;
            case 'N':
                return 23;
            case 'O':
                return 24;
            case 'P':
                return 25;
            case 'Q':
                return 26;
            case 'R':
                return 27;
            case 'S':
                return 28;
            case 'T':
                return 29;
            case 'U':
                return 30;
            case 'V':
                return 31;
            case 'W':
                return 32;
            case 'X':
                return 33;
            case 'Y':
                return 34;
            case 'Z':
                return 35;
            default:
                throw new IllegalArgumentException("Invalid character: " + n);
        }
    }

    // Hiển thị chử trong JTexx
    public class PlaceholderTextField extends JTextField {

        private final String placeholder;

        public PlaceholderTextField(String placeholder, Font font) {
            this.placeholder = placeholder;
            setForeground(Color.GRAY);
            setText(placeholder);
            setHorizontalAlignment(JTextField.RIGHT);
            setFont(font);

            addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals(placeholder)) {
                        setForeground(Color.BLACK);
                        setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (getText().isEmpty()) {
                        setForeground(Color.GRAY);
                        setText(placeholder);
                    }
                }
            });
        }

        // Phương thức reset
        public void reset() {
            setForeground(Color.GRAY);
            setText(placeholder); // Khôi phục placeholder
        }

        public String getPlaceholder() {
            return placeholder;
        }
    }

    public static String Calculator_Algorithm(String first_number, int first_base_number,
            String second_number, int second_base_number, int final_base_number,
            int operation) {

        int Dec_First_Number = Integer.parseInt(first_number, first_base_number);
        String first_number_result = Integer.toString(Dec_First_Number, 10);
        int Dec_Second_Number = Integer.parseInt(second_number, second_base_number);
        String second_number_result = Integer.toString(Dec_Second_Number, 10);
        String result;
        int Addition, Subtraction, Multiplication;
        switch (operation) {
            case 0:// +
                Addition = Integer.parseInt(first_number_result) + Integer.parseInt(second_number_result);
                result = Integer.toString(Addition, final_base_number);
                return result;
            case 1:// -
                Subtraction = Integer.parseInt(first_number_result) - Integer.parseInt(second_number_result);
                result = Integer.toString(Subtraction, final_base_number);
                return result;
            case 2:// x
                Multiplication = Integer.parseInt(first_number_result) * Integer.parseInt(second_number_result);
                result = Integer.toString(Multiplication, final_base_number);
                return result;
            case 3:// :
                if (Dec_Second_Number == 0) {
                    JOptionPane.showMessageDialog(null, "phép tính không thể chia cho 0");
                    return null;
                }
                if (Dec_First_Number % Dec_Second_Number != 0) {
                    JOptionPane.showMessageDialog(null, "Phép toán không thể chia hết");
                    return null;
                } else {
                    int integer_division = Dec_First_Number / Dec_Second_Number;
                    result = Integer.toString(integer_division, final_base_number);
                    return result;
                }
            default:
                JOptionPane.showMessageDialog(null, "Phép toán không hợp lệ");
                return null;
        }
    }
}
