# 💣 Campo Minado

Este é um projeto de um jogo de Campo Minado desenvolvido em Java. O jogo é jogado no console e permite ao usuário abrir campos, marcar campos como suspeitos de conter minas e reiniciar o jogo.

## 🎯 Estrutura do Projeto

- `br/com/cod3r/cm/Aplicacao.java`: Classe principal que inicia o jogo.
- `br/com/cod3r/cm/modelo/Tabuleiro.java`: Classe que representa o tabuleiro do jogo.
- `br/com/cod3r/cm/modelo/Campo.java`: Classe que representa cada campo do tabuleiro.
- `br/com/cod3r/cm/visao/TabuleiroConsole.java`: Classe responsável pela interação com o usuário via console.
- `br/com/cod3r/cm/excecao/ExplosaoException.java`: Exceção lançada quando uma mina é aberta.
- `br/com/cod3r/cm/excecao/SairException.java`: Exceção lançada quando o usuário decide sair do jogo.

## 🎮 Como Jogar

1. Execute a classe `Aplicacao` para iniciar o jogo.
2. O jogo irá solicitar coordenadas para abrir ou marcar campos.
3. Digite as coordenadas no formato `x, y` e escolha a ação:
   - `1` para abrir o campo.
   - `2` para marcar/desmarcar o campo.
4. O objetivo é abrir todos os campos que não contêm minas.
5. Se você abrir um campo com uma mina, você perde o jogo.
6. Você pode reiniciar o jogo após cada partida.

## 🧪 Testes

Os testes estão localizados no diretório `Test` e cobrem os principais casos de uso do jogo, incluindo abertura de campos, marcação de campos, reinicialização do tabuleiro e verificação do estado do jogo.

## 🛠️ Requisitos

- Java 8 ou superior
- IntelliJ IDEA ou outra IDE de sua preferência

## 🚀 Executando os Testes

Para executar os testes, utilize a sua IDE ou uma ferramenta de build como Maven ou Gradle.
