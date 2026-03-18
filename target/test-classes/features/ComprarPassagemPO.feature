# language: pt
Funcionalidade: Comprar Passagem PO
  Escolher e comprar uma passagem aereas

  Esquema do Cenario: Comprar com sucesso PO
    Dado que acesso o site "https://blazedemo.com/" PO
    Quando seleciono a "<origem>" e "<destino>" PO
    E clico no botao Find Flights PO
    Entao visualiza a lista de voos PO
    Exemplos:
      | origem    | destino |
      | São Paolo | Cairo   |
      | Boston    | London  |
  
