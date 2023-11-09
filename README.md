# FireBook ![Image](https://raw.githubusercontent.com/GabrielBAssis/FireBook_A3/main/src/main/resources/imagens/firebook65x65.png)

---

#### O que é?

FireBook é um projeto universitário em grupo, desenvolvido em **Java** no NetBeans, com utilização de *JFrame* e *JOptionPane* do pacote *javax.swing* para o desenvolvimento da interface gráfica. No programa os usuários são autenticados com login e senha no banco de dados **MySQL** disponibilizado em nuvem por meio do serviço web *aiven.io*, e então podem realizar cadastros e avaliações de livros, além de poderem ver a lista completa dos livros cadastrados no sistema.

Criado para avaliação final "A3" de Programação de Soluções Computacionais em Universidade São Judas Tadeu.

---

#### Entregas esperadas:

1. O sistema deve ser uma solução desktop com interface gráfica e banco de dados.

2. A interface gráfica deve ser desenvolvida utilizando-se classes do pacote javax.swing.

3. O banco de dados deve ser gerenciado pelo MySQL ou PostgreSQL.

4. O sistema deve ter controle de acesso: somente usuários autenticados podem ter acesso
a suas funcionalidades.

5. Deve haver dois tipos de usuários no sistema: usuários administradores e comuns.

6. Um usuário administrador será cadastrado diretamente na base de dados, previamente.

7. Administradores devem ter acesso às seguintes funcionalidades.

- a. Cadastro de usuários. Usuários têm, pelo menos, nome, idade, sexo e até dois tipos de
livros preferidos. Os tipos são previamente cadastrados e são eles: romance, ficção e
técnico.

8. Usuários comuns têm acesso a duas funcionalidades:

- a. Cadastro de livro. Quando um usuário comum faz login, ele é capaz de cadastrar livros
que tenha lido. Livros têm, pelo menos, título, autor e tipo. A cada livro cadastrado, um
usuário deve associar uma nota de 0 a 10, indicando o quanto ele gostou daquele livro.

- b. Visualização de livros. Usuários comuns devem ser capazes de ver a lista completa de
livros cadastrados por todos os usuários do sistema. Ela deve ser ordenada de acordo com
a média das notas recebidas. Livros melhor avaliados aparecem primeiro. A nota média de
um livro é igual ao somatório de todas as notas recebidas dividido pelo número de usuários
que já o avaliaram. Se houver empate, os livros que tiveram mais avaliações devem aparecer
primeiro. Se empatar novamente, o desempate deve ser feito pelo título do livro.

---

#### Cronograma de entregas:

08/10: Fazer release no GitHub contendo
- Interface gráfica para login, ainda sem funcionalidades
- OBS: O repositório Git deve conter o projeto NetBeans completo.
- Mensagem da tag: Entrega01(gui): GUI de login sem funcionalidades

15/10: Fazer release no GitHub contendo
- Script (arquivo de extensão .sql) de criação do banco, ainda que incompleto.
- Eventuais ajustes das entregas passadas.
- Mensagem da tag: Entrega02(bd): Script do banco de dados

29/10: Fazer release no GitHub contendo
- Login funcionando, validando tanto usuário admin quanto comum. Uma vez feito o login, o
usuário é levado para uma outra tela, ainda sem funcionalidades.
- Mensagem da tag: Entrega03(gui): Login funcionando

05/11: Fazer release no Github contendo
- Quando logado com admin, deve ser possível cadastrar usuários.
- Mensagem da tag: Entrega04(admin): Cadastro de usuários

12/11: Fazer release no Github contendo
- Quando logado com usuário comum, deve ser possível cadastrar livros.
- Mensagem da tag: Entrega05(comum): Cadastro de livros

26/11: Fazer release no Github contendo
- Quando logado como usuário comum, deve ser possível visualizar a lista de livros
ordenada
- Mensagem da tag: Entrega06(comum): Visualização de lista de livros

---

#### Integrantes:

- [Gabriel Bell Assis](https://github.com/GabrielBAssis/)
- [Lucas Carrieri Dos Santos](https://github.com/LucasCarrieri/)
- [Lucas Martins Teixeira](https://github.com/LucasMLag/)

---