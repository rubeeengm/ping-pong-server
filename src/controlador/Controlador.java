package controlador;

import javax.swing.JFrame;
import modelo.Pelota;
import modelo.ConexionServidor;
import modelo.DatosServidor;
import modelo.Raqueta;
import modelo.Raqueta2;
import vista.Vista;

public class Controlador extends JFrame{
    private Pelota pelota;
    private Raqueta r1;
    private Raqueta2 r2;
    private int golpes, golpes2;
    public Vista v;
    public DatosServidor ds;
    public ConexionServidor cs;
    
    public Controlador(Vista vista){
        this.v = vista;
        pelota = new Pelota(this.v.getWidth(), this.v.getHeight());
	r1 = new Raqueta(this.v.getHeight());
	r2 = new Raqueta2(this.v.getHeight());
	this.v.p = pelota;
        this.v.r1 = r1;
        this.v.r2 = r2;
        ds = new DatosServidor();
        cs = new ConexionServidor(ds,r1,r2);
        vista.cs = cs;
        golpes = 0;
	golpes2 = 0;
    }
    
    public void moverMundo(){
	pelota.movimiento();
	
        if(colision()){
            pelota.rebotar();
            
            //golpes = golpes + 1;
            //v.marcador.setText(String.valueOf(golpes / 2));	
	}
	
        if(colision2()){
            pelota.rebotar();
            
            //golpes2 = golpes2 + 1;
            //v.marcador2.setText(String.valueOf(golpes2 / 2));		
	}
	
        if(pelota.tocaFondo()){		
            //gameOver();
            golpes = golpes + 1;
            v.marcador.setText(String.valueOf(golpes / 2));	
	}       
    }
    //Cuando la pelota choca contra la raqueta
    public boolean colision(){
	return pelota.limite().intersects(r1.limite());
    }
    
    public boolean colision2(){
	return pelota.limite().intersects(r2.limite());
    }

    public void gameOver() {
	/*if(golpes>golpes2){
            JOptionPane.showMessageDialog(this,"El jugador 1 ganó", "Game Over", JOptionPane.YES_NO_OPTION);
            System.exit(0);
	}
        
        else{
            if(golpes<golpes2){
                JOptionPane.showMessageDialog(this, "El jugador 2 ganó", "Game Over", JOptionPane.YES_NO_OPTION);
                System.exit(0);
            }
            
            else{
		JOptionPane.showMessageDialog(this, "Empate", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(0);
            }
	}*/
    }
}