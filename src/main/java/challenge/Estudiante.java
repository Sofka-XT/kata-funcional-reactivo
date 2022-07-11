package challenge;

import java.util.List;

public class Estudiante implements Comparable<Estudiante> {
    private final String nombre;
    private final Integer puntaje;
    private final List<Integer>  asistencias;

    private boolean aprobado;


    public Estudiante(String nombre, Integer puntaje, List<Integer>  asistencias) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.asistencias = asistencias;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getNombre() {
        return nombre;
    }


    public Integer getPuntaje() {
        return puntaje;
    }


    @Override
    public int compareTo(Estudiante before) {
        return this.getPuntaje() - before.getPuntaje();
    }

    public List<Integer> getAsistencias() {
        return asistencias;
    }
}