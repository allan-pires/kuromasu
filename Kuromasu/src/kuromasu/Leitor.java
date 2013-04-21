/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuromasu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import kuromasu.Quadrado.Tipo;

/**
 * @author doislan
 */
public class Leitor {
    static String path = "/home/doislan/NetBeansProjects/Kuromasu/src/kuromasu/instancias/";
    static String name = "instancia1";
    Leitor(){
  
    }
    
    Leitor(String nome){
        this.name = nome;
    }
    
    public ArrayList<Quadrado> lerProblema() throws FileNotFoundException, IOException  {
        
        int ordem = 0;
        ArrayList<Quadrado> quadradosNumerados = new ArrayList<>();
    
        // Cria stream do arquivo de instancia
        FileInputStream fis = new FileInputStream(path+name+".txt");
       
        // Inicia leitura do arquivo
        try (Scanner scanner = new Scanner(fis)) {
            
            // Marcador da coordenada Y e ordem do problema
            int contador_y = 0;
            
            // Enquanto tiver uma proxima linha ...
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                
                // Seta a ordem do problema
                if (line.startsWith("Ordem = ")){
                    ordem = Integer.parseInt(line.substring(8, line.length()));
                }
                
                // Chama o handler para a linha
                else{
                    if (!line.isEmpty()){
                        quadradosNumerados = handleCharacters(quadradosNumerados, line, contador_y);
                        contador_y++;
                    }
                }
                
            }
        }
        return quadradosNumerados;
    } 

    // Verifica quando um elemento eh cinza ou numerado e instancia no tabuleiro
    private ArrayList<Quadrado> handleCharacters(ArrayList<Quadrado> array, String line, int y) throws IOException {            
        // Transforma a linha em um array de chars e percorre
        line = line.replaceAll("\\s","");
        char[] chars = line.toCharArray();
        
        for (int i = 0; i < chars.length; i++){
            // Se o quadrado for cinza, seta como cinza
            if (chars[i] != 'C'){
                int valor = Integer.parseInt(String.valueOf(chars[i]));
                Quadrado q = new Quadrado(Tipo.NUMERADO, i, y, valor);
                array.add(q);
            }
        }
        
        return array;

    }
    
}
