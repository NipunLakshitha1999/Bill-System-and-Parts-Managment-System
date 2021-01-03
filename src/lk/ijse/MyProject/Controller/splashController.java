/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.MyProject.Controller;

import lk.ijse.MyProject.view.newLogin;
import lk.ijse.MyProject.view.splashScreen;


/**
 *
 * @author Nipun Lakshitha
 */
public class splashController {

    public static void main(String[] args) {
        splashScreen splash = new splashScreen();
        splash.setVisible(true);

        try {
            for (int i = 0; i <= 100; i++) {

                Thread.sleep(50);
               splash.ProgressBar.setValue(i);
               

                if (i == 100) {
                    splash.dispose();
                    new newLogin().setVisible(true);
                }
            }
        } catch (Exception e) {
        }
    }

}
