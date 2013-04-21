/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuromasu;

import java.util.ArrayList;
import kuromasu.Quadrado.Tipo;

/**
 *
 * @author doislan
 */

// Gerencia todos os processamentos de dados referentes a busca de solucao e
// sua validacao
public class Controlador {
    
    Quadrado[][] tabuleiro;
    
    // Instancia um tabuleiro com quadrados numerados
    public boolean criarTabuleiro(ArrayList<Quadrado> quadradosNumerados, int ordem){
        
        // Cria um tabuleiro com todos os quadrados cinzas e valor 0
        for (int i = 0; i < ordem; i++){
            for (int j = 0; j < ordem; j++){
                tabuleiro[i][j].tipo = Tipo.CINZA;
                tabuleiro[i][j].valor = 0;
                tabuleiro[i][j].x = i;
                tabuleiro[i][j].y = j;
            }
        }
        
        // Adiciona os quadrados brancos enumerados no tabuleiro
        for (int i = 0; i < quadradosNumerados.size(); i++){
            tabuleiro[quadradosNumerados.get(i).x][quadradosNumerados.get(i).y].valor = quadradosNumerados.get(i).valor;
            tabuleiro[quadradosNumerados.get(i).x][quadradosNumerados.get(i).y].tipo = Tipo.NUMERADO;
        }
        
        return true;
    }
    
    // Verifica todos os quadrados enumerados quanto a validade da solucao
    public boolean quadradoValido(Quadrado quadrado){
        
        // Contado inicia com valor 1, pois um quadrado enumerado tambem eh um
        // quadrado branco
        int contador = 1;
        
        // Verifica se eh um quadrado numerado
        if (quadrado.tipo.equals(Tipo.NUMERADO)){
            
            // Percorre todas as casas ACIMA do quadrado
            for (int i = quadrado.y+1; i < tabuleiro.length; i++){
                if (tabuleiro[quadrado.x][i].tipo == Tipo.BRANCO) contador++;
                
                else{
                    
                    // Verifica se ha quadrados pretos adjacentes
                    if(tabuleiro[quadrado.x][i].tipo == Tipo.PRETO) return false;
                    break;
                }
            }
            
            // Percorre todas as casas ABAIXO do quadrado
            for (int i = quadrado.y-1; i < tabuleiro.length; i--){
                if (pretoAdjacente(tabuleiro[quadrado.x][i])) contador++;
                
                else{
                    
                    // Verifica se ha quadrados pretos adjacentes
                    if(pretoAdjacente(tabuleiro[quadrado.x][i])) return false;
                    break;
                }
            }
            
            // Percorre todas as casas do LADO ESQUERDO do quadrado
            for (int i = quadrado.x-1; i < tabuleiro.length; i++){
                if (tabuleiro[i][quadrado.y].tipo == Tipo.BRANCO) contador++;
                
                else{
                    
                    // Verifica se ha quadrados pretos adjacentes
                    if(pretoAdjacente(tabuleiro[i][quadrado.y])) return false;
                    break;
                }
            }
            
            // Percorre todas as casas do LADO DIREITO do quadrado
            for (int i = quadrado.x+1; i < tabuleiro.length; i++){
                if (tabuleiro[i][quadrado.y].tipo == Tipo.BRANCO) contador++;
                
                else{
                    
                    // Verifica se ha quadrados pretos adjacentes
                    if(pretoAdjacente(tabuleiro[i][quadrado.y])) return false;
                    break;
                }
            }
            
            // Caso o numero de casas visiveis seja igual ao valor do quadrado
            // o valor retornado é TRUE
            return(contador == quadrado.valor);
        }   
        else return false;
    }
    
    // Verifica todos os quadrados adjacentes de um quadrado,
    // caso um deles seja preto retorna true
    public boolean pretoAdjacente(Quadrado quadrado){
        
        // Verifica se o lado esquerdo eh preto
        if (quadrado.x > 0 && tabuleiro[quadrado.x - 1][quadrado.y].tipo == Tipo.PRETO) {
            return true;
        }
        
        // Verifica se o lado direito eh preto
        if (quadrado.x < tabuleiro.length - 1 && tabuleiro[quadrado.x + 1][quadrado.y].tipo == Tipo.PRETO) {
            return true;
        }
        
        // Verifica se o quadrado abaixo eh preto
        if (quadrado.y > 0 && tabuleiro[quadrado.x][quadrado.y - 1].tipo == Tipo.PRETO) {
            return true;
        }
        
        // Verifica se o quadrado acima eh preto
        if (quadrado.y < tabuleiro.length - 1 && tabuleiro[quadrado.x][quadrado.y + 1].tipo == Tipo.PRETO) {
            return true;
        }
        return false;
    }
    
    // Imprime a configuracao do tabuleiro
    public void imprimirTabuleiro(){
        for (int i = 0; i < tabuleiro.length; i++){
            for (int j = 0; j < tabuleiro.length; j++){
                if (tabuleiro[j][i].tipo == Tipo.CINZA) System.out.print("   ,");
                if (tabuleiro[j][i].tipo == Tipo.BRANCO) System.out.print("   ,");
                if (tabuleiro[j][i].tipo == Tipo.NUMERADO) System.out.print(" "+tabuleiro[i][j].valor+" ,");
                if (tabuleiro[j][i].tipo == Tipo.PRETO) System.out.print(" # ,");
            }
            System.out.println();
        }
    }
    
}
