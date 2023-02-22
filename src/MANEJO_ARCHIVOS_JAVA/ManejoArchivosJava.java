package MANEJO_ARCHIVOS_JAVA;

import java.io.*;

public class ManejoArchivosJava {


    // creacion de archivo en memoria  (file) y en disco duro (printWirter)
    public static void crearArchivo(String nombreArchivo) {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el sigueinte archivo  " + salida);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }


    }


    public static void escribirArchivo(String nombreArchivo, String contenido) {

        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(archivo);
            // en contenido se pude ingresar objetos o tpos primitivos
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha escrito  informacion al archivo    " + salida);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        ;


    }

    public static void anexarArchivo(String nombreArchvo, String contenido) {

        File archivo = new File(nombreArchvo);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            // en contenido se pude ingresar objetos o tpos primitivos
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha aderido informacion al  archivo  sigueinte archivo :  " + nombreArchvo);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }


    }

    public static void leerArchivo(String nombreArchivo) {

        var archivo = new File(nombreArchivo);
        try {

            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {
                System.out.println("lectura linea \n" + lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        ;


    }


}
