package Operation;


import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Manis
 */
public class ImageOperation {
    public static void operate(int key){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        // file FileInputStream
        try{
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            int i = 0;
            for(byte b: data){
                System.out.println(b);
                data[i] = (byte)(b^key);
                i++;
            }
            
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        System.out.println("this is testing");
        // Creating GUI using JFrame
        JFrame f = new JFrame();
        // setting title
        f.setTitle("Image Operation");
        // set size
        f.setSize(400, 400);
        // set location relative to null so that it will in center
        f.setLocationRelativeTo(null);
        // for closing window, we do JFrame.EXIT_ON_CLOSE because when we want to close window then it will close
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // for knowing that our window is visible or not 
        
        
        Font font = new Font("Roboto", Font.BOLD, 25);
        // creating button
        JButton button = new JButton();
        button.setText("Open Image");
        button.setFont(font);
        
        
        
        //creating text field
        JTextField textField = new JTextField(10);
        textField.setFont(font);
        
        
        // addActionListener is a interface
        button.addActionListener(e ->{
            System.out.println("button clicked");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });
        
        
        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);
        f.setVisible(true);
        
    }
}
