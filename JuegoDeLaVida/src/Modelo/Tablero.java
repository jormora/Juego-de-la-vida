/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jorge Morales
 */
public class Tablero {
    private int[][] table;

    public Tablero() throws FileNotFoundException {
        this.table = new int[100][100];
        /*for (int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++){
                this.table[i][j] = 0;
            }
        }*/
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (Math.random() <= 0.2) {
                    this.table[i][j] = 1;
                }
            }
        }
    }

    public int[][] getTable() {
        return table;
    }
    
    public void leerDatos() throws FileNotFoundException{
        int fila;
        int columna;
        File file = new File("cells.txt");
        Scanner s = new Scanner(file);
        while(s.hasNextInt()){
            fila = s.nextInt();
            columna = s.nextInt();
            this.table[fila][columna] = 1;
        }
        s.close();
    }
    
    public int[][] modificar(){
        int[][] tb = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                tb[i][j] = 0;
            }
        }
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                rules(tb, i, j);
            }
        }
        return tb;
    }
    
    public int vecinos(int i, int j){
        int vecinos = 0;
        if((i>0&&j>0)&&(i<99&&j<99)){
            vecinos += this.table[i-1][j-1];
            vecinos += this.table[i-1][j];
            vecinos += this.table[i-1][j+1];
            vecinos += this.table[i][j-1];
            vecinos += this.table[i][j+1];
            vecinos += this.table[i+1][j-1];
            vecinos += this.table[i+1][j];
            vecinos += this.table[i+1][j+1];
        }/*else{
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    vecinos += this.table[(k+i+99)%100][(l+j+99)%100];
                }
            }
            if(this.table[i][j]==1){
                vecinos -= 1;
            }
        }*/
        return vecinos;
    }
    
    public void rules(int[][] table2, int i, int j){
        if(vecinos(i, j) < 2 || vecinos(i, j) > 3){
            table2[i][j] = 0;
            //System.out.println("Die. No population or overpopulation.");
        } else if(vecinos(i, j) == 3){
            table2[i][j] = 1;
            //System.out.println("Born or stay alive");
        } else{
            table2[i][j] = this.table[i][j];
        }
    }
    
    public void cambiarTablero(int[][] t){
        this.table = t;
    }
}
