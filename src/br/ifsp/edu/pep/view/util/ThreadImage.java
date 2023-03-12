/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsp.edu.pep.view.util;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Aluno
 */
public class ThreadImage implements Runnable {

    private JLabel label;

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        try {
            sleep(2000);
            ImageIcon img = new ImageIcon(getClass().getResource("../icon/sino.png"));
            label.setIcon(img);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
