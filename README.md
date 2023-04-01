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



