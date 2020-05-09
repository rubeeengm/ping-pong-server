package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ConexionServidor {
    public ServerSocket serverSocket = null;
    public Socket socket;
    public DatosServidor ds;
    public InputStream fBE;
    public Reader fCE;
    public BufferedReader entrada;
    public OutputStream fBS;
    public Writer fCS;
    public BufferedWriter salida;
    public Raqueta r1;
    public Raqueta2 r2;
    
    public ConexionServidor(DatosServidor ds, Raqueta r1, Raqueta2 r2){
        this.ds = ds;
        this.r1 = r1;
        this.r2  = r2;
    }

    public void inicioEsperaConexion(){
        try{
            this.serverSocket = new ServerSocket(ds.puerto);
            System.out.println("Estoy esperando al cliente");
            this.socket       = this.serverSocket.accept();
            //envio();
            //recepcion();
            System.out.println("ya conectó");
        } catch(IOException ioe) { }
    }
    
    public void recepcion(){
        String msg;
        
        try{
            fBE = this.socket.getInputStream();
            fCE = new InputStreamReader(fBE);
            entrada = new BufferedReader(fCE);  
            
            //do{
                    msg = entrada.readLine();
                    int ms = Integer.parseInt(msg);
                    r2.setY(ms);
                    
            //} while(true);
        } catch(IOException ioe) { }
    }
    
    public void envio(){
        ds.mensaje = String.valueOf(r1.getY());
        
        try{
            PrintWriter escribir = new PrintWriter(socket.getOutputStream(), true);
             
            escribir.println(ds.mensaje);            
        } catch(IOException ioe) {  
            
        }
    }
}