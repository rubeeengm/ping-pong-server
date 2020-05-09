package modelo;

public class DatosServidor {
    public String mensaje;
    public int puerto = 2882;

    public DatosServidor(){
        mensaje = null;
        puerto = 2882;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}