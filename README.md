# Requisitos:

## Parte 1:

Usando springboot (java) desenvolva um REST controller, com um endpoint POST que receba um body JSON com os seguintes campos:
{cnpj: string, faturamento: number, taxaDebito: number, taxaCredito: number, rr: boolean}

O endpoint deve validar a obrigatoriedade de TODOS os campos e devolver um status 200 se tudo estiver OK, 
caso contrário, retornar status 500

## Parte 2:

1. Disponibilizar o projeto anterior no git e continuar com as melhorias a seguir
2. Adicionar campo codigoMcc no JSON de REQUEST do POST, deve ser um Inteiro OBRIGATÓRIO
3. Passar a validar o CNPJ informado no POST (validação de dígito verificador), caso inválido, retornar 403
4. Passar a validar taxas de acordo com o faturamento ( além de ser obrigatório, as taxas informadas no post não podem ser maiores que as minimas, nem maiores que as máximas) em caso de falha, retornar 500
    4.1 Taxas minimas (deb, cred, parc) 1.0, 1.5 e 2.0 aumentar o minimo em 0.2 a cada R$5000 de faturamento
    4.1 Taxas maximas (deb, cred, parc) 7.0, 6.5 e 12.0 aumentar o maximo em 0.1 a cada R$5000 de faturamento
5. Salvar os dados recebidos do POST em arquivo TXT (multiplos registros) *será necessário criar um identificador único para cada registro
6. Criar endpoint GET para LISTAR os registros do arquivo em JSON, nessa lista os campos devem estar em string e formatados, campos de taxa (xx,xx%), o campo de CNPJ com máscara padrão, faturamento com máscara de real, e o campo boolean de RR deve ser substituido por um string "Possui RR" ou "Não possui RR"
7. Criar endpoint PATCH para atualizar SOMENTE os campos de taxa de um registro ( todas as regras do post se aplicam )
8. criar uma blacklist de mccs, e qualquer mcc vindo pelo post, que esteja na lista, deve ter o registro recusado e retornado erro 500

    BLACKLIST: 1731,3219,3246,3357,3388,3441,3505,3520,3579,3640,3771,4131,4215,4468,5046,5072,5139,5169,5231,5261,5541,5571,5651,5655,5697,5699,5713,5732,5733,5931,5943,5967,5971,5973,5993,5994,5995,5998,7217,7276,7297,7299
