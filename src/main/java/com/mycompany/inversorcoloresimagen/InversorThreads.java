package com.mycompany.inversorcoloresimagen;

import java.awt.image.BufferedImage;

/* @author Gabriel Murillo */


public class InversorThreads implements Runnable{
    
    private final BufferedImage imagen;
    private final int inicioFila;
    private final int finFila;

    public InversorThreads(BufferedImage imagen, int inicioFila, int finFila) {
        this.imagen = imagen;
        this.inicioFila = inicioFila;
        this.finFila = finFila;
    }

    @Override
    public void run() {
        //ivertir pixel por pixel
        for(int y=inicioFila; y < finFila; y++){
            for(int x= 0; x < imagen.getWidth(); x++){
                int rgb = imagen.getRGB(x, y);
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
                imagen.setRGB(x, y, invertedRGB);       
            }
        }
        
    }
    
    
}
