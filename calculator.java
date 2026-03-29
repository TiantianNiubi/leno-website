import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    // 按钮布局
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton decBtn, equBtn, delBtn, clrBtn, negBtn;
    JPanel panel;

    // 计算变量
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator() {
        // 窗口设置
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320, 480);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // 窗口居中

        // 文本显示框
        textField = new JTextField();
        textField.setBounds(10, 20, 290, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);

        // 功能按钮
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("×");
        divBtn = new JButton("÷");
        decBtn = new JButton(".");
        equBtn = new JButton("=");
        delBtn = new JButton("⌫");
        clrBtn = new JButton("C");
        negBtn = new JButton("+/-");

        functionButtons[0] = addBtn;
        functionButtons[1] = subBtn;
        functionButtons[2] = mulBtn;
        functionButtons[3] = divBtn;
        functionButtons[4] = decBtn;
        functionButtons[5] = equBtn;
        functionButtons[6] = delBtn;
        functionButtons[7] = clrBtn;
        functionButtons[8] = negBtn;

        // 数字按钮
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        // 为所有按钮添加监听
        for (JButton btn : functionButtons) {
            btn.addActionListener(this);
            btn.setFont(new Font("Arial", Font.PLAIN, 20));
            btn.setFocusable(false);
        }
        for (JButton btn : numberButtons) {
            btn.addActionListener(this);
            btn.setFont(new Font("Arial", Font.PLAIN, 20));
            btn.setFocusable(false);
        }

        // 按钮面板布局
        panel = new JPanel();
        panel.setBounds(10, 80, 290, 350);
        panel.setLayout(new GridLayout(6, 4, 5, 5));

        // 第一行（简化版，和截图对应）
        panel.add(new JButton("MC"));
        panel.add(new JButton("MR"));
        panel.add(new JButton("M+"));
        panel.add(new JButton("M-"));
        panel.add(new JButton("MS"));
        panel.add(new JButton("M∨"));
        panel.add(new JButton("%"));
        panel.add(new JButton("CE"));
        panel.add(clrBtn);
        panel.add(delBtn);
        panel.add(new JButton("⅟ₓ"));
        panel.add(new JButton("x²"));
        panel.add(new JButton("²√x"));
        panel.add(divBtn);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulBtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subBtn);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addBtn);
        panel.add(negBtn);
        panel.add(numberButtons[0]);
        panel.add(decBtn);
        panel.add(equBtn);

        // 等号按钮特殊样式
        equBtn.setBackground(Color.BLUE);
        equBtn.setForeground(Color.WHITE);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 数字按钮处理
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }
        // 小数点处理
        if (e.getSource() == decBtn) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        }
        // 清空处理
        if (e.getSource() == clrBtn) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            operator = '\0';
        }
        // 删除处理
        if (e.getSource() == delBtn) {
            String str = textField.getText();
            if (!str.isEmpty()) {
                textField.setText(str.substring(0, str.length() - 1));
            }
        }
        // 正负号处理
        if (e.getSource() == negBtn) {
            if (!textField.getText().isEmpty()) {
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(String.valueOf(temp));
            }
        }
        // 运算符处理
        if (e.getSource() == addBtn || e.getSource() == subBtn || e.getSource() == mulBtn || e.getSource() == divBtn) {
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                operator = e.getActionCommand().charAt(0);
                textField.setText("");
            }
        }
        // 等号计算处理
        if (e.getSource() == equBtn) {
            if (!textField.getText().isEmpty() && operator != '\0') {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '×':
                        result = num1 * num2;
                        break;
                    case '÷':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            textField.setText("Error");
                            return;
                        }
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
                operator = '\0';
            }
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }
}