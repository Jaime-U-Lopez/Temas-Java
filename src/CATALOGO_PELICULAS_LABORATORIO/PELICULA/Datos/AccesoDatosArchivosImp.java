package CATALOGO_PELICULAS_LABORATORIO.PELICULA.Datos;

import CATALOGO_PELICULAS_LABORATORIO.PELICULA.Exception.AccesosDatosEx;
import CATALOGO_PELICULAS_LABORATORIO.PELICULA.Exception.ExcrituraDatosEx;
import CATALOGO_PELICULAS_LABORATORIO.PELICULA.Exception.LecturasDatosEx;
import CATALOGO_PELICULAS_LABORATORIO.PELICULA.PeliculasDomain.Pelicula;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosArchivosImp implements AccesoDatos {
    @Override
    public Boolean existe(String nombreRecurso) throws AccesosDatosEx {

        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturasDatosEx {


        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }

            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturasDatosEx("Excepcion al listar peliculas  ");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new LecturasDatosEx("Excepcion al listar peliculas  ");
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws ExcrituraDatosEx {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            //ojo en este caso que no estamos bajo el metodo estandar es con ToString o sino se debe de retirar
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("se  escribio pelicula en el archivo= " );
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new ExcrituraDatosEx("Error de escritura");
        }


    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturasDatosEx {

        File archivo = new File(nombreArchivo);
        String resultado = null;

        try {
            BufferedReader entrada = new BufferedReader( new FileReader(archivo));

            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while (linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula" + linea+ "Encontrada en el indice "+ indice;
                    break;
                };
                linea = entrada.readLine();
                indice++;
            }

            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturasDatosEx("Excepcion al buscar  peliculas  ");

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturasDatosEx("Excepcion al buscar  peliculas  ");
        }

        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesosDatosEx {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter((new FileWriter(archivo)));
            salida.close();;

        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new AccesosDatosEx( "Error de al crear achivo");

        }

    }

    @Override
    public void borrar(String nombreArchivo) throws AccesosDatosEx {

        File archivo= new File(nombreArchivo);

        if (archivo.exists()){
            archivo.delete();
            System.out.println("se ha elimiinado archivo " + archivo);
        }

    }
}
