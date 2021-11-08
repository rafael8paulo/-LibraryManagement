package util;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Alertas {
    
    public void mensagem1(String mensagem)
    {     
        JOptionPane.showMessageDialog(null,mensagem, "Library Management", JOptionPane.WARNING_MESSAGE);
    }
}