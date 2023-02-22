package CATALOGO_PELICULAS_LABORATORIO.PELICULA.Servicio;

import CATALOGO_PELICULAS_LABORATORIO.PELICULA.Datos.AccesoDatos;
import CATALOGO_PELICULAS_LABORATORIO.PELICULA.Datos.AccesoDatosArchivosImp;
import CATALOGO_PELICULAS_LABORATORIO.PELICULA.Exception.AccesosDatosEx;
import CATALOGO_PELICULAS_LABORATORIO.PELICULA.PeliculasDomain.Pelicula;

public class CatalogoPeliculasImp implements CatalogoPeliculas {

    private final AccesoDatos datos;

    public CatalogoPeliculasImp() {
        this.datos = new AccesoDatosArchivosImp();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        Boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesosDatosEx ex) {
            System.out.println("Error de accedo de datos ");
            ex.printStackTrace(System.out);

        }

    }

    @Override
    public void listarPeliculas() {

        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (var pelicula : peliculas) {
                System.out.println("pelicula = " + pelicula);

            }

        } catch (AccesosDatosEx Ex) {

            System.out.println("Error de acceso de datos  ");
            Ex.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPeliculas(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);

        } catch (AccesosDatosEx Ex) {

            System.out.println("Error de acceso de datos  ");
            Ex.printStackTrace(System.out);
        }

        System.out.println("resultado = " + resultado);

    }

    @Override
    public void iniciarCatalogoPeliculas() {

        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {

                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);

            } else {

                datos.crear(NOMBRE_RECURSO);
            }
            ;

        } catch (AccesosDatosEx Ex) {
            System.out.println("Error al iniciar el catalogo   ");
            Ex.printStackTrace(System.out);

        }

    }




    /*

    reponsabilidad

    Contiene las implementaciones de las operaciones necesariasa  de la aplicacion catalogoPeliculas
     */

}
