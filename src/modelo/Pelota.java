package modelo;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pelota{
    private int x ,y, direccionX, direccionY, alto, ancho, diametro;
	
    public Pelota(int ancho , int alto) {
        this.ancho = ancho;
	this.alto = alto;
	x = 0;
	y = 0;
	direccionX = 27;
	direccionY = 27;
	diametro = 20;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDireccionX() {
        return direccionX;
    }

    public void setDireccionX(int direccionX) {
        this.direccionX = direccionX;
    }

    public int getDireccionY() {
        return direccionY;
    }

    public void setDireccionY(int direccionY) {
        this.direccionY = direccionY;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }
        
    public void movimiento(){
	if(x + direccionX > ancho - 40)
            direccionX = -27;
	
        if(x + direccionX < 0)
            direccionX = 27;
	
	if(y + direccionY > alto - 60)
            direccionY = -27;
		
	if(y + direccionY < 0)
            direccionY = 27;
		
	x = x + direccionX;
	y = y + direccionY;
    }
    
    public void pintar(Graphics2D g){
        g.fillOval(5 + x, 30 + y, 20, 20);	
    }
        
    public Rectangle limite(){
        return new Rectangle(5 + x, 30 + y, diametro, diametro );	
    }
        
    public void rebotar(){
	if(x + direccionX > 40)
            direccionX = direccionX - 27;
        
        else
            direccionX = direccionX + 27;		
    }
    
    public boolean tocaFondo(){
        //System.out.println("1. "+x + direccionX + " : "+ (ancho-40));
        //System.out.println("2. "+x + direccionX);
        //return x + direccionX > ancho-40 || x + direccionX<0;
        System.out.println(x+direccionX);
        
        return x + direccionX < 0;
    }
}