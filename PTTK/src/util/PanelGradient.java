
package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JPanel;


public class PanelGradient extends javax.swing.JPanel{

    public PanelGradient() {
        initComponents();
        //Set false to make background panel
        setOpaque(false);
        colors = new ArrayList<>();
    }
    
//    public PanelGradient(JPanel panel) {
//        // Copy properties from panel to this PanelGradient
//        // For example:
//        this.setSize(panel.getSize());
//        // Copy other properties as needed
//    }

    private ArrayList<ModelColor> colors; 
    public void addColor(ModelColor ...color)
    {
        for(ModelColor c : color)
        {
            colors.add(c);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
     
    @Override
    protected void paintComponent(Graphics grphcs) {
        if(!colors.isEmpty())
        {
            int width = getWidth();
            int height = getHeight();
            Graphics2D g2 = (Graphics2D) grphcs;
            Color color[] = new Color[colors.size()];
            float position[] = new float[colors.size()];
            
            for(int i=0; i<colors.size(); i++)
            {
                color[i] = colors.get(i).getColor();
                position[i] = colors.get(i).getPosition();
            }
            int sx=0, sy=0, ex=width, ey=0;
            LinearGradientPaint g = new LinearGradientPaint(sx, sy, ex, ey, position, color);
            g2.setPaint(g);
            g2.fillRect(0, 0, width, height);
        }
        super.paintComponent(grphcs); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
