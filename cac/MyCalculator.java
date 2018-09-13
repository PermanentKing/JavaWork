import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.util.Stack;  
import javax.swing.*;  
  
class MyException extends Exception{  
    public MyException() {  
        super();  
    }  
    public MyException(String message) {  
        super(message);  
    }  
}  
  
 class SwingConsole{  
    public static void run(final JFrame f,final int width,final int height){  
        SwingUtilities.invokeLater(new Runnable(){  
            public void run(){  
                f.setTitle(f.getClass().getSimpleName());  
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                f.setSize(width,height);  
                f.setVisible(true);  
            }  
        });  
    }  
}  
  
public class MyCalculator extends JFrame{  
    /* 
     *  
     */  
  
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;               //输入文本框  
    private String input1;
    private String input2;                       //结果  
    private String operator;                    //操作符  
          
    public MyCalculator() {  
        input1 = "";
        input2 = "";
        operator = "";
          
        Container container = this.getContentPane();  
        JPanel panel = new JPanel();  
        textField1 = new JTextField(30);
        textField2 = new JTextField(" ", 30);
        textField3 = new JTextField(30);
        textField4 = new JTextField("=", 30);
        textField5 = new JTextField(" ", 30);

        textField2.setEditable(false);
        textField4.setEditable(false);
        textField5.setEditable(false);                      //文本框禁止编辑

        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField4.setHorizontalAlignment(JTextField.CENTER);
        textField5.setHorizontalAlignment(JTextField.CENTER);
        //textField.setHorizontalAlignment(JTextField.LEFT);  
        //textField.setBounds(100, 100, 20, 20);            //在容器布局为空情况下生效  
        textField1.setPreferredSize(new Dimension(30,30));
        textField2.setPreferredSize(new Dimension(30,30));
        textField3.setPreferredSize(new Dimension(30,30));
        textField4.setPreferredSize(new Dimension(30,30));
        textField5.setPreferredSize(new Dimension(30,30)); 
        /*container.add(textField1, BorderLayout.NORTH);
        container.add(textField2, BorderLayout.NORTH);
        container.add(textField3, BorderLayout.NORTH);
        container.add(textField4, BorderLayout.NORTH);
        container.add(textField5, BorderLayout.NORTH);*/

          
        String[] name= {"+","-","*","/","OK"};  
          
        panel.setLayout(new GridLayout(2,4,1,1));
        panel.add(textField1);
        panel.add(textField2);
        panel.add(textField3);
        panel.add(textField4);
        panel.add(textField5);

          
        for(int i=0;i<name.length;i++) {  
            JButton button = new JButton(name[i]);  
            button.addActionListener(new MyActionListener());  
            panel.add(button);  
        }  
        container.add(panel,BorderLayout.CENTER);  
    }  
      
    class MyActionListener implements ActionListener{           //内部类实现按钮响应  
  
        @Override  
        public void actionPerformed(ActionEvent e) {  
            int cnt=0;  
            String actionCommand = e.getActionCommand();            //获取按钮上的字符串  
            if(actionCommand.equals("+") || actionCommand.equals("-") || actionCommand.equals("*")  || actionCommand.equals("/")) {  
                operator = actionCommand;
                textField2.setText(actionCommand);
            }  
            /*else if(actionCommand.equals("C")) {                    //清除输入  
                input1 = "";
                input2 = ""  
            }*/  
            else if(actionCommand.equals("OK")) {                    //按下等号  
                //try {  
                    //input += "="+calculate(input);
                    input1 = textField1.getText();
                    input2 = textField3.getText();
                    double a = Double.parseDouble(input1);
                    double b = Double.parseDouble(input2);
                    double output = 0;
                    switch (operator) {  
                        case "+":  
                            output = a+b;  
                            break;  
                        case "-":  
                            output = a-b;  
                            break;  
                        case "*":  
                            output = a*b;  
                            break;  
                        case "/":  
                            output = a/b;  
                            break;  
                        } 
                //} catch (MyException e1) {  
                    /*if(e1.getMessage().equals("Infinity"))  
                        input+= "=" + e1.getMessage();  
                    else  
                        input = e1.getMessage();*/  
                //}  
                textField5.setText(Double.toString(output));  
                input1=""; 
                input2=""; 
                cnt = 1;
            } else{

            } 
            //else  
                //input += actionCommand;                         //按下数字  
              
            //if(cnt == 0)  
                //textField.setText();  
        }  
    }
 
      
    /*private String calculate(String input) throws MyException{              //计算函数  
        String[] comput = input.split(" ");                   
        Stack<Double> stack = new Stack<>();  
        Double m = Double.parseDouble(comput[0]);  
        stack.push(m);                                      //第一个操作数入栈  
          
        for(int i = 1; i < comput.length; i++) {  
            if(i%2==1) {                  
                if(comput[i].equals("+"))  
                    stack.push(Double.parseDouble(comput[i+1]));  
                if(comput[i].equals("-"))  
                    stack.push(-Double.parseDouble(comput[i+1]));  
                if(comput[i].equals("*")) {                 //将前一个数出栈做乘法再入栈  
                    Double d = stack.peek();                //取栈顶元素  
                    stack.pop();  
                    stack.push(d*Double.parseDouble(comput[i+1]));  
                }  
                if(comput[i].equals("/")) {                 //将前一个数出栈做乘法再入栈  
                     double help = Double.parseDouble(comput[i+1]);    
                     if(help == 0)  
                         throw new MyException("Infinity");         //不会继续执行该函数  
                     double d = stack.peek();   
                     stack.pop();   
                     stack.push(d/help);    
                }  
            }  
        }  
          
        double d = 0d;  
          
        while(!stack.isEmpty()) {           //求和  
            d += stack.peek();  
            stack.pop();  
        }  
          
        String result = String.valueOf(d);  
        return result;  
    }*/
  
    public static void main(String[] args) {  
        SwingConsole.run(new MyCalculator(), 300, 120);  
    }  
}