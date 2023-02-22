package CATALOGO_PELICULAS_LABORATORIO.PELICULA.Servicio;

public interface CatalogoPeliculas {

    String NOMBRE_RECURSO= "PELICULAS.TXT";

    void agregarPelicula(String nombrePelicula );
    void  listarPeliculas();
    void buscarPeliculas( String buscar);
    void iniciarCatalogoPeliculas();
    /*

    Responsabilidad:

    contiene las operaciones necesarias de la aplicacion  catalogoPeliculas
     */

}
