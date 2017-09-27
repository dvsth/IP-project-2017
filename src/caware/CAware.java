/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caware;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 12p10
 */
public class CAware {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DBHandler dbHandler = new DBHandler();
        HomeForm homeForm = new HomeForm(dbHandler);
        homeForm.setVisible(true);
    }
}
