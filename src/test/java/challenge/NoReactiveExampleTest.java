package challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import challenge.Estudiante;
import challenge.NoReactiveExample;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class NoReactiveExampleTest {

    @InjectMocks
    NoReactiveExample noReactiveExample;


    @Test
    void sumaDePuntajes(){

        //arrange
        //act
        var valor = noReactiveExample.sumaDePuntajes();
        //assert
        Assertions.assertEquals(260, valor);
    }

    @Test
    void mayorPuntajeDeEstudiante(){

        //arrange
        //act
        var valor = noReactiveExample.mayorPuntajeDeEstudiante(1);
        //assert
        Assertions.assertEquals("pedro", valor.get(0).getNombre());
    }

    @Test
    void totalDeAsisntenciasDeEstudiantesComMayorPuntajeDe(){

        //arrange
        //act
        var valor = noReactiveExample.totalDeAsisntenciasDeEstudiantesConMayorPuntajeDe(75);
        //assert
        System.out.println(valor);
    }

    @Test
    void elEstudianteTieneAsistenciasCorrectas(){

        //arrange
        //act
        var valor = noReactiveExample.elEstudianteTieneAsistenciasCorrectas(
                new Estudiante("raul", 30, List.of(5,2,1,4,5))
        );
        //assert
        Assertions.assertTrue(valor);
    }

    @Test
    void promedioDePuntajesPorEstudiantes(){

        //arrange
        //act
        var valor = noReactiveExample.promedioDePuntajesPorEstudiantes();
        //assert
        Assertions.assertEquals(52, valor);
    }

    @Test
    void estudiantesAprovados(){
        //arrange
        //act
        var valor = noReactiveExample.estudiantesAprovados();
        //assert
        System.out.println(valor);
    }
}