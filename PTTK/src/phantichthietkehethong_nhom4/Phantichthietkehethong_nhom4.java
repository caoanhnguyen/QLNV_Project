package phantichthietkehethong_nhom4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import Dangnhap.Dangnhap;
import LoadingPage.LoadingPage;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import util.PanelGradient;

/**
 *
 * @author Admin
 */
public class Phantichthietkehethong_nhom4 {

    /**
     * @param panelGradient
     * @return 
     */
    
    public static boolean kiemTraRong(PanelGradient panelGradient){
        
        
        Component[] comp = panelGradient.getComponents();
        for(Component component: comp){
            
            if(component instanceof JTextField){
                JTextField textField = (JTextField) component;
                if(textField.getText().isEmpty()){
                    return false;
                }
            }
                else if(component instanceof JPasswordField){
                    JPasswordField passwordFiled = (JPasswordField) component;
                    if(passwordFiled.getPassword().length == 0){
                        return false;
                    }
                }
                else if(component instanceof JComboBox){
                    JComboBox comboBox = (JComboBox) component;
                    if(comboBox.getSelectedItem().toString().equals("")){
                        return false; 
                    }
                }
                else if(component instanceof JCheckBox){
                    JCheckBox checkbox = (JCheckBox) component;
                    if(!checkbox.isSelected()){
                        return false;
                    }
                }else if(component instanceof JTextArea){
                    JTextArea ta = (JTextArea) component;
                    if(!ta.getText().isEmpty()){
                        return false;
                    }
                }
            
            }
        
        return true;
    }
    public static void resetForm(PanelGradient panelGradient){
        Component[] comp = panelGradient.getComponents();
        for(Component component : comp){
                if (component instanceof JTextField) {
                    
                    ((JTextField) component).setText("");
                } else if (component instanceof JPasswordField) {
                    ((JPasswordField) component).setText("");
                } else if (component instanceof JComboBox) {
                    ((JComboBox) component).setSelectedIndex(0);
                } else if (component instanceof JCheckBox) {
                    ((JCheckBox) component).setSelected(false);
                }else if(component instanceof JTextArea) {
                    ((JTextArea) component).setText("");
                }else if(component instanceof JRadioButton) {
                    ((JRadioButton) component).setSelected(false);
                }
                
            }
    }
    
    public static boolean kiemTraRong(JPanel jpanel){
        
        
        Component[] comp = jpanel.getComponents();
        for(Component component: comp){
            
            if(component instanceof JTextField){
                JTextField textField = (JTextField) component;
                if(textField.getText().isEmpty()){
                    return false;
                }
            }
                else if(component instanceof JPasswordField){
                    JPasswordField passwordFiled = (JPasswordField) component;
                    if(passwordFiled.getPassword().length == 0){
                        return false;
                    }
                }
                else if(component instanceof JComboBox){
                    JComboBox comboBox = (JComboBox) component;
                    if(comboBox.getSelectedItem().toString().equals("")){
                        return false; 
                    }
                }
                else if(component instanceof JTextArea){
                    JTextArea ta = (JTextArea) component;
                    if(!ta.getText().isEmpty()){
                        return false;
                    }
                }
            }
        
        return true;
    }
    
    public static boolean kiemTraRong(JPanel jpanel, JComboBox cbBox){
        
        
        Component[] comp = jpanel.getComponents();
        for(Component component: comp){
            
            if(component instanceof JTextField){
                JTextField textField = (JTextField) component;
                if(textField.getText().isEmpty()){
                    return false;
                }
            }
                else if(component instanceof JPasswordField){
                    JPasswordField passwordFiled = (JPasswordField) component;
                    if(passwordFiled.getPassword().length == 0){
                        return false;
                    }
                }
                else if(component instanceof JComboBox){
                    JComboBox comboBox = (JComboBox) component;
                    if(comboBox.equals(cbBox)){
                    }
                    else if(comboBox.getSelectedItem().toString().equals("")){
                        return false;
                    }
                    
                }
                else if(component instanceof JTextArea){
                    JTextArea ta = (JTextArea) component;
                    if(!ta.getText().isEmpty()){
                        return false;
                    }
                }else if(component instanceof JRadioButton) {
                    
                }
            }
        
        return true;
    }
    
    
    public static void resetForm(JPanel jpanel){
        Component[] comp = jpanel.getComponents();
        for(Component component : comp){
                if (component instanceof JTextField) {
                    ((JTextField) component).setText("");
                } else if (component instanceof JPasswordField) {
                    ((JPasswordField) component).setText("");
                } else if (component instanceof JComboBox) {
                    ((JComboBox) component).setSelectedItem("");
                } else if (component instanceof JCheckBox) {
                    ((JCheckBox) component).setSelected(false);
                }else if(component instanceof JTextArea) {
                    ((JTextArea) component).setText("");
                }else if(component instanceof JRadioButton) {
                    ((JRadioButton) component).setSelected(false);
                }
            }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
//        Dangnhap dn = new Dangnhap();
//        dn.setVisible(true);
        LoadingPage lf = new LoadingPage();
        lf.setVisible(true);
        lf.setLocationRelativeTo(null);
        Dangnhap dn = new Dangnhap();
        try {
            for (int i = 0; i <= 100; i+=2){
                Thread.sleep(100);
                LoadingPage.jlbProcess.setText(i + "%");
                if(i == 10)
                {
                    LoadingPage.jlbLoading.setText("Turning on ...");
                }
                if(i == 20)
                {
                    LoadingPage.jlbLoading.setText("Loading Module ...");
                }
                if(i == 50)
                {
                    LoadingPage.jlbLoading.setText("Connecting Database ...");
                }
                if(i == 70)
                {
                    LoadingPage.jlbLoading.setText("Connecting Successfull ...");
                }
                if(i == 80)
                {
                    LoadingPage.jlbLoading.setText("Lauching Application ...");
                }
                if(i == 100)
                {
                    lf.setVisible(false);
                    dn.setVisible(true);
                }
                LoadingPage.ldProcess.setValue(i);
            }
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
