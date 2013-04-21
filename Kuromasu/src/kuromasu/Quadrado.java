/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuromasu;

/**
 *
 * @author doislan
 */
public class Quadrado {
    
    public enum Tipo{
        CINZA,
        PRETO,
        BRANCO,
        NUMERADO;
    }
    
    Tipo tipo;  // Tipo de quadrado 
    int x;      // Posicao na abscissa X
    int y;      // Posicao na abscissa Y
    int valor;      // Valor

   // Construtor
    public Quadrado(Tipo tipo, int x, int y, int valor) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        
        // Verifica se o quadrado pode ter valor
        if(tipo == Tipo.NUMERADO) this.valor = valor;
        else this.valor = 0;
    }
    
    public Quadrado(){
        this.tipo = Tipo.CINZA;
        this.valor = 0;
    }
}
