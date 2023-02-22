import MANEJO_ARCHIVOS_JAVA.ManejoArchivosJava;

public class Main {
    public static void main(String[] args) {

        var nombreArchivo = "prueba.txt";
        //ManejoArchivosJava.crearArchivo(nombreArchivo);
       // ManejoArchivosJava.escribirArchivo(nombreArchivo,"hola esto es una prueba");

        //ManejoArchivosJava.anexarArchivo(nombreArchivo, "agregame esto otro");
        ManejoArchivosJava.leerArchivo(nombreArchivo);
    }
}
