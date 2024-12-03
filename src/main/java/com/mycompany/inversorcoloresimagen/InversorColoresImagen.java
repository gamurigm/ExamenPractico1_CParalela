package com.mycompany.inversorcoloresimagen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/* @author Gabriel Murillo */


public class InversorColoresImagen {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("C:\\Users\\gamur\\OneDrive - UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE\\Documents\\NetBeansProjects\\InversorColoresImagen\\img\\img15.jpg");
        BufferedImage image = ImageIO.read(inputFile);
        int width = image.getWidth();
        int height = image.getHeight();
        long inicio = System.nanoTime();
        
        //ivertir pixel por pixel
        for(int y=0; y < height; y++){
            for(int x= 0; x < width; x++){
                int rgb = image.getRGB(x, y);
                // extraer los componentes RGB
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                
                //invertir colores
                int invertedRed = 255 - red;
                int invertedGreen = 255 - green;
                int invertedBlue = 255 -  blue;
                //combinar
                int invertedRGB = (invertedRed << 16 )| (invertedGreen << 8) | invertedBlue;
                image.setRGB(x, y, invertedRGB);       
            }
        }
        
        long fin = System.nanoTime();
        
        File outputFile = new File("imagen_invertida_paralela.jpg");
        ImageIO.write(image, "jpg", outputFile);
        System.out.println("Tiempo de Ejecución Paralela: " + (fin - inicio)/ 1_000_000 + " ms");
                
    }
}
