/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

/**
 *
 * @author Biben
 */
import java.util.*;
import java.io.*;

public class RecursiveFactorial {

    public static void main(String[] args) {
        System.out.println("hey");

        String str = "12000000334341212";
        String[] hati = str.split("-");
        //   System.out.println("heh "+hati.length);
//       for(int x=0;x<hati.length;x++ ){
//           if((hati[x].equals(""))||(hati[x]==null)||(hati[x].isEmpty())){
//           
//           }else{
//           System.out.println("heh "+hati[x]);
//           }
//           
//       }
        RecursiveFactorial n = new RecursiveFactorial();
//
//        int num = n.factorial(3);
//        int[] nums = {1, 2, 3, 4};
//        System.out.println("Hey beybe " + num);
//        System.out.println("clums " + nums.length);

        n.clumps("80766550867676999");

    }

    public int clumps(String str) {
        int clumps = 0;
        for (int x = 0; x <= 9; x++) {

            //str[x];
            String nstr = str;
            for (int y = 0; y <= 9; y++) {

                if (x != y) {

                    nstr = nstr.replace(y + "", "-");
                }
                // str.re

            }//end of innerloop

            String[] hati = nstr.split("-");
            System.out.println("ang nstr " + nstr + "  haba " + hati.length);
            //System.out.println("");
            System.out.println("\nbatch  " + x);
            for (int p = 0; p < hati.length; p++) {
                
                System.out.println("divide is "+hati[p] + "");
                if(hati[p].length()>=2){
                clumps++;
                }
                
            }
            System.out.println("\n");

        }
        System.out.println("Clumps is "+clumps);
        return clumps;
    }

    public int res = 1;

    public int process(int num) {

        int ctr = num - 1;

        //  if
        return num;
    }
    int ctr = 0;
    int result = 1;
    int multiplier = 0;

    public int factorial(int num) {

        if (this.ctr == 0) {
            //meanig unpisa plang
            this.ctr = num;

        }

        this.result = this.ctr * this.result;

        // System.out.println("Dumadaan "+this.result);
        this.ctr--;

        if (this.ctr != 0) {
            this.factorial(num);
        }

        return this.result;
    }

}
