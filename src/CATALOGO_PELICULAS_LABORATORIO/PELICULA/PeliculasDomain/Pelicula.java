package CATALOGO_PELICULAS_LABORATORIO.PELICULA.PeliculasDomain;


public class Pelicula   {
    private String name;

    public Pelicula(){};
    public Pelicula(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /*

    respponsabilidad:
    crear OBjetos peliculas que alimenttan el app catalogo.
     */
}
