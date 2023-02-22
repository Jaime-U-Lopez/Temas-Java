package CATALOGO_PELICULAS_LABORATORIO.PELICULA.Datos;

import CATALOGO_PELICULAS_LABORATORIO.PELICULA.Exception.AccesosDatosEx;
import CATALOGO_PELICULAS_LABORATORIO.PELICULA.Exception.ExcrituraDatosEx;
import CATALOGO_PELICULAS_LABORATORIO.PELICULA.Exception.LecturasDatosEx;
import CATALOGO_PELICULAS_LABORATORIO.PELICULA.PeliculasDomain.Pelicula;
import java.util.List;

public interface AccesoDatos {

     Boolean existe( String nombreRecurso ) throws AccesosDatosEx;
     List<Pelicula> listar (String NOMBRE) throws LecturasDatosEx;

     void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar  ) throws ExcrituraDatosEx;
     String buscar( String nombreArchivo,String buscar) throws LecturasDatosEx;
     void crear( String nombreArchivo) throws AccesosDatosEx;
     void borrar( String nombreArchivo) throws AccesosDatosEx;


     // cocntiene las operaciones para ejecutar en el archvio peliculas.txt
}
