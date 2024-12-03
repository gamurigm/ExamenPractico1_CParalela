package com.mycompany.inversorcoloresimagen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/* @author Gabriel Murillo */


public class InversorColoresImagen {

    public static void main(String[] args) throws IOException {
        
        try{
            File inputFile = new File("C:\\Users\\gamur\\OneDrive - UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE\\Documents\\NetBeansProjects\\InversorColoresImagen\\img\\img15.jpg");
        BufferedImage image = ImageIO.read(inputFile);
        int width = image.getWidth();
        int height = image.getHeight();
        
        
        System.out.println("Procesando imagen de " + width + "x" + height);
        
        int numeroHilos = 4; // Dividir en 4 partes
        Thread[] hilos = new Thread[numeroHilos];

        int filasPorHilo = height / numeroHilos;
        int finFila;
            
        long inicio = System.nanoTime();   
        
        
        for (int i = 0; i < numeroHilos; i++) {
                int inicioFila = i * filasPorHilo;
                
                if(i == numeroHilos - 1){
                    finFila = height;
                }else{
                    finFila = inicioFila + filasPorHilo;
                }

                hilos[i] = new Thread(new InversorThreads(image, inicioFila, finFila));
                hilos[i].start();
            }

            // Esperar a que todos los hilos terminen
            for (Thread hilo : hilos) {
                hilo.join();
            }
            
            File outputFile = new File("imagen_invertida_paralela.jpg");
            ImageIO.write(image, "jpg", outputFile);
            
            long fin = System.nanoTime();
            
            System.out.println("Tiempo de Ejecución Paralela: " + (fin - inicio)/ 1_000_000 + " ms");
            
        }
        catch(IOException | InterruptedException e) {
        }
                
    }
}
