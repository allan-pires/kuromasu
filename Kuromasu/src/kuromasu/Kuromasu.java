/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuromasu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author doislan
 */
public class Kuromasu {
    
    public static ArrayList<Quadrado> quadradosNumerados = new ArrayList<>();
    public Quadrado[][] solucao;
    public static Controlador controlador;
    public static int ordem;
    
    // Cria um tabuleiro
    public boolean criarTabuleiro(){
        return controlador.criarTabuleiro(quadradosNumerados, ordem);
    }
    
    // Verifica todos os quadrados enumerados
    public boolean verificarSolucao(){
        for (int i = 0; i < quadradosNumerados.length; i++){
            if (!controlador.quadradoValido(quadradosNumerados[i])) return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Leitor problema = new Leitor();
        quadradosNumerados = problema.lerProblema();
        controlador.criarTabuleiro(quadradosNumerados, ordem);
        controlador.imprimirTabuleiro();
    }
}
