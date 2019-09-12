#language: pt
Funcionalidade: 
  Eu como usuario final
  Quero acessar o site Automation Practice
  Para fazer uma compra de um produto

  Esquema do Cenario: Fazendo compra no site Automation Practice
   	Dado que acesso o site
    Quando escolho um produto "<produto>"
    E adiciono o produto escolhido ao carrinho
    E prossigo para o checkout
    E confirmo se o produto esta no carrinho para continuar a compra
    E clico no botao para avancar
    E forneco um endereco de email para criar uma conta
    E clico no botao para criar uma nova conta
    E preencho minhas informacoes pessoais comecando por genero "<genero>"
    E informo meu primeiro nome "<primeiro nome>"
    E informo meu ultimo nome "<ultimo nome>"
    E informo novamente o endereco de mesmo endereco de email que escolhi
    E informo uma senha "<senha>"
    E informo meu dia de aniversario "<diaAniv>"
		E informo meu mes de aniversario "<mesAniv>"
		E informo meu ano de nascimento "<anoAniv>"
		E informo o endereco "<endereco>"
		E informo a cidade "<cidade>"
		E informo o estado
		E preencho o Cep "<cep>"
		E adiciono informacoes adicionais
		E adiciono um numero de telefone "<numTel>"
		E adiciono um email alternativo "<altEmail>"
		E clico em 'registrar'
		E confiro se o endereco de entrega esta correto e prossigo
		E aceito os termos de servico e prossigo
		E confiro o valor da compra
		E seleciono a forma de pagamento como transferencia bancaria
		E clico no botao para confirmar a compra
		Entao minha compra foi realizada com sucesso
    Exemplos: 
      | produto       | genero       | primeiro nome   | ultimo nome | senha | diaAniv|mesAniv  | anoAniv | endereco            | cidade    |cep  |numTel      | altEmail         |
      | Printed Dress | masculino    | Tester          | BRQ         | teste | 21     |2        | 1996    | rua teste, numero 26| alphaville|00000|011933333333|tesxxxr@tester.com|
