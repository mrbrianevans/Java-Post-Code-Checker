/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postcodes;

import javax.swing.JOptionPane;

/**
 *
 * @author ebria
 */
public class Postcodes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x;
        System.out.println("Here are the six valid formats for a UK postcode:");
        String[] option = {"AA9A 9AA","A9A 9AA","A9 9AA","A99 9AA","AA9 9AA","AA99 9AA"};
        for (int i = 0; i < 6; i++) {
            x=i+1;
            System.out.println(x + " - " + option[i]);
        }
        String postcode = JOptionPane.showInputDialog("Enter a postcode:");
        char[] digit = new char[postcode.length()];
        
        for (int i = 0; i < postcode.length(); i++) {
            digit[i] = postcode.charAt(i);
        }
        System.out.println("You entered: "+postcode);
        String format = "";
        for (int i = 0; i < postcode.length(); i++) {
            x=(int)digit[i];
            if (64<x && x<91) {
                format = format+"A";
            }else if(47<x && x<58){
                format = format+"9";
            }else if(x==32){
                format = format+" ";
            }else if(96<x && x<120){
                format = format+"A";
            }else{
                System.out.println("You have entered an invalid character");
            }
        }
        
        boolean valid = false;
        for (int i = 0; i < 6; i++) {
            x=i+1;
            if (format.equals(option[i])) {
                System.out.println("Your post code is number "+x+" on the list."
                        + "\nIt is a valid UK postcode following the format"
                        + " "+option[i]+"");
                valid = true;
            }
        }
        if (valid==false) {
            System.out.println("You have entered an invalid postcode");
        }
    }
    
}
