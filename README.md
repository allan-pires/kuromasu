Kuromasu
========

## Informações
Kuromasu ou também conhecido como "Where is the black cell" é um jogo de quebra-cabeça de determinação binária criado por ano Nikoli (criador de sudoku).

## Como jogar
Kuromasu é jogado em um tabuleiro retangular. Algumas casas do tabuleiro possuem números. Cada casa pode ser preenchida com preto ou com branco. O objetivo do jogo é determinar qual é a cor de cada casa.

As seguintes regras determinar quais as células que são:
- Cada número no tabuleiro representa o número de casas brancas que pode ser visto a partir da casa numerada. Uma casa pode ser visto a partir de outra casa se estiverem na mesma linha ou coluna, e não existem casas pretas entre elas nessa linha ou coluna.
- Casas numeradas nunca são pretas.
- Não devem haver casas pretas adjacentes (horizontalmente ou verticalmente).
- Todas as casas brancas devem estar ligadas (horizontalmente ou verticalmente).

## Classes
- [Controlador](https://github.com/doisLan/Kuromasu/blob/master/Kuromasu/src/kuromasu/Controlador.java): Gerencia todos os processamentos de dados referentes a busca de solução e sua validação.
- [Kuromasu](https://github.com/doisLan/Kuromasu/blob/master/Kuromasu/src/kuromasu/Kuromasu.java): Classe Main do projeto.
- [Leitor](https://github.com/doisLan/Kuromasu/blob/master/Kuromasu/src/kuromasu/Leitor.java): Lê uma instância de tabuleiro em um arquivo de texto.
- [Quadrado](https://github.com/doisLan/Kuromasu/blob/master/Kuromasu/src/kuromasu/Quadrado.java): Modelo de casas de um tabuleiro.
