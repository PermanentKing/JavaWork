import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
import javax.swing.*;  
  
  
public class calcu {
    int i = 0; 
    Button deng = new Button("   =    ");
    JButton addButt = new JButton("  +  ");
    JButton subButt = new JButton("  -  ");
    JButton mulButt = new JButton("  *  ");
    JButton divButt = new JButton("  /  "); 
    TextField  tx1 = new TextField(8);//创建相应的组件  
    TextField  tx2 = new TextField(8);
    TextField  tx3 = new TextField(8);
    //Choice list = new Choice();   
    public static void main(String[] args) {          
        new calcu().init();          
    }     
    public void init(){  
        //list.add("+");list.add("-");list.add("*");list.add("/");          
        deng.addActionListener(new ActionHandler());          
        Frame f = new Frame();  //声明容器    
        f.setLayout(new FlowLayout());  //设置布局    
        f.add(tx1);  
        //f.add(list);  
        f.add(tx2);
        f.add(tx3); 
        f.add(deng); 
        f.add(addButt);
        f.add(subButt);
        f.add(mulButt);
        f.add(divButt);
        f.setSize(400, 300);  
        f.setLocation(500, 350);          
        f.setVisible(true);       
    }  
class ActionHandler implements ActionListener{  
  
    @Override
    public void actionPerformed(ActionEvent e) {          
        /* 
         * 根据符号，进行运算，放置结果，晴空前面输入数据 
         */  
  
        //通过实践可以得到事件源，通过实践源可以得到容器，通过容器可以打得所有的组件。          
        String op1  =tx1.getText();  
        String op2 = tx2.getText();       
        double a;  
        double b;  
        try {  
            a = Double.parseDouble(op1);  
            b = Double.parseDouble(op2);  
        } catch (NumberFormatException e1) {              
            tx3.setText("输入数据不正确!!,重新输入");            
            return;  
        }         
        double r = 0.0;       
        //String op = list.getSelectedItem();       
        char c = op.charAt(0);        
        switch (c) {  
        case '+':  
            r = a+b;  
            break;  
        case '-':  
            r = a-b;  
            break;  
        case '*':  
            r = a*b;  
            break;  
        case '/':  
            r = a/b;  
            break;  
        }         
        tx3.setText(r+"");        
        tx1.setText("");  
        tx2.setText("");          
    }   
}
class actionMatch implements ActionListener{
    public void actionPerformed(ActionEvent e){

    }
}

}
