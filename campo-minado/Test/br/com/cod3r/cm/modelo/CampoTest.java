package br.com.cod3r.cm.modelo;

import br.com.cod3r.cm.excecao.ExplosaoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CampoTest {

    private Campo campo = new Campo(3, 3);

    @BeforeEach
    void iniciarCampo() {
        campo = new Campo(3, 3);
    }

    @Test
    void testeVizinhoRealDistancia1Esquerda() {
        Campo vizinho = new Campo(3, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1Direita() {
        Campo vizinho = new Campo(3, 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1EmCima() {
        Campo vizinho = new Campo(2, 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1EmBaixo() {
        Campo vizinho = new Campo(4, 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia2() {
        Campo vizinho = new Campo(2, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeNaoVizinho() {
        Campo vizinho = new Campo(1, 1);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(!resultado);
    }
    @Test
    void testeValorPadraoAtributoMarcado() {
        assertFalse(campo.isMarcado());
    }
    @Test
    void testeAlternarMarcacao() {
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }
    @Test
    void testeAlternarMarcacaoDuasChamadas() {
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }
    @Test
    void testeAbrirNaoMinadoNaoMarcado() {
        assertTrue(campo.abrir());
    }
    @Test
    void testeAbrirNaoMinadoMarcado() {
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }
    @Test
    void testeAbrirMinadoMarcado() {
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }
    @Test
    void testeAbrirMinadoNaoMarcado() {
        campo.minar();

        assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });
    }
    @Test
    void testeAbrirComVizinhos() {
        Campo campo11 = new Campo(1, 1);
        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);

        campo.adicionarVizinho(campo22);

        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isAberto());
    }
    @Test
    void testeAbrirComVizinhos2() {
        Campo campo11 = new Campo(1, 1);
        Campo campo12 = new Campo(1, 1);
        campo12.minar();

        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isFechado());
    }
    @Test
    void testeReiniciar() {
        campo.alternarMarcacao();
        campo.abrir();
        campo.minar();

        campo.reiniciar();

        assertTrue(campo.isFechado() && !campo.isMarcado() && !campo.isMinado());
    }
    @Test
    void testeToStringMarcado() {
        campo.alternarMarcacao();
        assertEquals("⛳", campo.toString());
    }
    @Test
    void testeToStringAbertoMinado() {
        campo.abrir();
        campo.minar();
        assertEquals("\uD83D\uDCA3", campo.toString());
    }
    @Test
    void testeToStringAbertoNaoMinado() {
        campo.abrir();
        assertEquals(" ", campo.toString());
    }
    @Test
    void testeToStringFechado() {
        assertEquals("❓", campo.toString());
    }
    @Test
    void testeMinasNaVizinhanca0() {
        assertEquals(0, campo.minasNaVizinhanca());
    }
    @Test
    void testeMinasNaVizinhanca3() {
        Campo campo22 = new Campo(2, 2);
        Campo campo11 = new Campo(1, 1);
        campo22.adicionarVizinho(campo11);
        Campo campo12 = new Campo(1, 2);
        campo22.adicionarVizinho(campo12);
        Campo campo21 = new Campo(2, 1);
        campo22.adicionarVizinho(campo21);

        campo.adicionarVizinho(campo22);

        campo12.minar();
        campo21.minar();

        assertEquals(2, campo22.minasNaVizinhanca());
    }
    @Test
    void testeMinasNaVizinhanca3ComMarcacao() {
        Campo campo22 = new Campo(2, 2);
        Campo campo11 = new Campo(1, 1);
        campo22.adicionarVizinho(campo11);
        Campo campo12 = new Campo(1, 2);
        campo22.adicionarVizinho(campo12);
        Campo campo21 = new Campo(2, 1);
        campo22.adicionarVizinho(campo21);

        campo.adicionarVizinho(campo22);

        campo12.minar();
        campo21.minar();

        campo11.alternarMarcacao();

        assertEquals(2, campo22.minasNaVizinhanca());
    }
}