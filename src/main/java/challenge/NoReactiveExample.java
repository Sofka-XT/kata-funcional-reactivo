package challenge;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NoReactiveExample {

    public static final int VALOR_PERMITIDO = 15;
    private final List<Estudiante> estudianteList;

    public NoReactiveExample() {
        estudianteList = List.of(
                new Estudiante("raul", 30, List.of(1, 2, 1, 4, 5)),
                new Estudiante("andres", 35, List.of(4, 2, 4, 3, 5)),
                new Estudiante("juan", 75, List.of(3, 2, 4, 5, 5)),
                new Estudiante("pedro", 80, List.of(5, 5, 4, 5, 5)),
                new Estudiante("santiago", 40, List.of(4, 5, 4, 5, 5))
        );
    }

    public Integer sumaDePuntajes() {
        return estudianteList.stream()
                .map(this.mapeoDeEstudianteAPuntaje())
                .reduce(0, Integer::sum);
    }

    private Function<Estudiante, Integer> mapeoDeEstudianteAPuntaje() {
        return Estudiante::getPuntaje;
    }

    public List<Estudiante> mayorPuntajeDeEstudiante(int limit) {
        return new TreeSet<>(estudianteList)
                .descendingSet()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Integer totalDeAsisntenciasDeEstudiantesConMayorPuntajeDe(int valor) {
        return estudianteList.stream()
                .filter(estudiante -> estudiante.getPuntaje() >= valor)
                .flatMap(estudiante -> estudiante.getAsistencias().stream())
                .reduce(0, Integer::sum);
    }

    public boolean elEstudianteTieneAsistenciasCorrectas(Estudiante estudiante) {
        return Optional.of(estudiante)
                .filter(this.asistenciasPemitidas())
                .isPresent();
    }


    public Double promedioDePuntajesPorEstudiantes() {
        double total = sumaDePuntajes();
        double cantidad = estudianteList.size();
        return total / cantidad;
    }

    private Predicate<Estudiante> asistenciasPemitidas() {
        return estudiante -> estudiante.getAsistencias()
                .stream()
                .reduce(0, Integer::sum) >= VALOR_PERMITIDO;
    }

    public List<String> losNombresDeEstudianteConPuntajeMayorA(int valor) {
        return estudianteList.stream()
                .filter(estudiante -> estudiante.getPuntaje() > valor)
                .map(Estudiante::getNombre)
                .collect(Collectors.toList());
    }

    private Estudiante aprobar(Estudiante estudiante) {
        return Optional.of(estudiante)
                .filter(e -> e.getPuntaje() >= 75)
                .map(e -> {
                    var est1 = new Estudiante(e.getNombre(), e.getPuntaje(), e.getAsistencias());
                    est1.setAprobado(true);
                    return est1;
                }).orElseGet(() -> estudiante);
    }


    public List<String> estudiantesAprovados(){
        return estudianteList.stream()
                .map(this::aprobar)
                .filter(Estudiante::isAprobado)
                .map(Estudiante::getNombre)
                .collect(Collectors.toList());
    }


}
