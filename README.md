# Projeto Locadora Distribuida  

## Objetivo
O objetivo deste projeto é fazer um gerenciador simples de uma locadora de filmes usando o conceito de sistemas distribuidos. 
Utilizando de **sockets**, o software programado em **java** possui um servidor onde todo o processamento é direcionado a ele, 
e um cliente, onde fica toda a interface do programa.  

## Funcionalidades  
O software possui diversas funcionalidades que auxiliam no gerenciamento básico de uma locadora de filmes.  

![Menu Locadora](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/MenuLocadoraDistribuida.png)  

#### CRUD filmes
No sistema é possivel **Cadastrar, buscar, listar e remover** filmes.  

![Exemplo cadastro filmes locadora](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/CadastroDeFilmesLocadoraDistribuida.png)  

![Exemplo listagem filmes locadora](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/ListagemFilmesLocadoraDistribuida.png)  

#### CRUD Clientes
No sistema também é possivel **Cadastrar, buscar, listar e remover** clientes.  

![Exemplo cadastro cliente](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/CadastroClienteLocadoraDistribuida.png)  

![Exemplo listagem cliente](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/ListagemClientesLocadoraDistribuida.png)

#### Calculo de taxa, alugar e devolver filmes e listar alugados  

O sistema permite fazer o calculo da taxa de aluguel de um filme, dependendo da quantidade de dias.  

![Exemplo calculo taxa de aluguel](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/CalculoTaxaLocadoraDistribuida.png)  

Outra funcionalidade é de alugar e devolver um filme, onde será vinculado um cliente a este aluguel.
![Exemplo aluguel de filme](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/AluguelFilmeLocadoraDistribuida.png)  

Por fim, temos a funcionalidade de listar os filmes alugados  
![Exemplo Listagem filmes alugados](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/ListagemFilmesAlugadosLocadoraDistribuida.png)  

## Documentação técnica  

### Classes  

#### Conexao  

A classe conexao tem como objetivo fazer a conexão entre cliente e servidor. Essa classe possue 2 métodos estáticos, sendo eles: 
send -> recebe um socket e um objeto, e tem como objetivo enviar-lo.  
receive -> recebe um socket, e tem como objetivo receber um objeto.  

![Classe conexao]()  

#### Servidor  

A classe servidor possui diversas funcionalidades. Logo de inicio, a classe inicia os sockets.  

![Sockets Servidor]()  

A classe possui um método main que irá realizar todas as funcionalidades da classe servidor. Primieramente são instanciados alguns ArrayList que funcionam como banco de dados não relacionais, após isso, é instanciado um MsgReq e MsgResp, que serão as classes de requisição e resposta.  

![Instanciação Servidor]()  

![connect servidor]()  

Caso o servidor tenha se conectado através da funcao connect(), ele recebe uma requisição do cliente indicando qual será a função que o servidor irá efeturar.  

- 0 -> Cadastrar usuário
- 1 -> Cadastrar filme  
- 2 -> Buscar usuário  
- 3 -> Buscar filme  
- 4 -> Listar clientes  
- 5 -> Listar filmes  
- 6 -> Remover cliente  
- 7 -> Removerr filme  
- 8 -> Calcular taxa  
- 9 -> Calcular multa  
- 10 -> Alugar filme  
- 11 -> Devolver filme 
- 12 -> Listar filmes alugados
- 99 -> Desligar servidor

![Exemplo funcionalidade cadastrar usuário e filme servidor]()  

#### Cliente  

A classe cliente é responsável por pegar as entradas do usuário e se comunicar com o servidor para que ele faça o devido processamento destas entradas. Logo de inicio, a classe cliente inicia os sockets:  

![Inicio Socket Cliente]()  

A classe possue um método main que irá realizar todas as funcionalidades. Primeiramente são instanciados um MsgReq e MsgResp, que serão as classes de requisição e resposta e um Scanner que irá fazer a entrada de dados. 

![Instanciação Cliente]()

Após isso começa a entrada de dados, que serão enviados ao servidor  

![Exemplo Cadastrar Usuario e Filme Cliente]()  

#### Usuario  

A classe usuáio possui 5 parametros, sendo eles:
- String nome;
- String sobrenome;
- String cpf;
- int idade;
- int id;  

E um construtor que recebe um nome, um sobrenome, um cpf, uma idade e um id.  

![Construtor classe Usuario]()  

##### Métodos

A classe possue "gets e sets" para todos os parametros.
Também possue um "método mágico" toString().  

![toString Usuario]()  

#### Filme  

A classe filme possue 5 parametros, sendo eles:  
- String nome;
- String genero;
- int ano;
- boolean alugado = false;
- int id;  

E um construtor que recebe um nome, um genero, um ano e um id.  

![Construtor classe Filme]()  

##### Métodos  

A classe possue "gets e sets" para todos os parametros.
Também possue 2 métodos, sendo eles um método mágico toString() e o outro um alugar, que muda o estado da variavel alugado.  

![Métodos da classe Filme]()  

#### Alugado  

A classe Alugado possue 2 parametros, sendo eles:  
- int idFilme;
- int idUsuario;

E um construtor que ecebe um idFilme e um idUsuario.

![Construtor classe Alugado]()  

##### Métodos  
A classe possue "gets e sets" para todos os parametros.  

#### MsgReq  

A classe MsgReq é utilizada para fazer uma requisição do cliente para o servidor. Então a classe possue diversos parametros e diversos construtores. Cada construtor pode auxiliar em uma ou mais funções do servidor.   

![Parametros MsgReq]()  

![Construtores MsgReq]()
![Construtores MsgReq2]()  

#### MsgResp  

A classe MsgResp é utilizada para enviar uma resposta do servidor ao cliente. A classe possue 2 parametros, sendo eles:  
- int status;
- String resposta;  

E 3 construtores, um deles não recebe parametros, o outro recebe apenas um status e o ultimo recebe um status e uma resposta.  

![Construtores classe MsgResp]()  

### Protocolo e Lista de Status  

![Protocolo]()  

![Lista de Status]()


