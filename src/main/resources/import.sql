INSERT INTO tb_status(descricao) VALUES ('Pendente de Processamento');
INSERT INTO tb_status(descricao) VALUES ('Processado');
INSERT INTO tb_status(descricao) VALUES ('Processado com Falha');

INSERT INTO tb_pagamento(cpf_cnpj, metodo_pagamento, num_cartao, valor, status_id) VALUES ('7942837923', 1, null, 534, 1);
INSERT INTO tb_pagamento(cpf_cnpj, metodo_pagamento, num_cartao, valor, status_id) VALUES ('4235236534', 2, null, 545, 2);
INSERT INTO tb_pagamento(cpf_cnpj, metodo_pagamento, num_cartao, valor, status_id) VALUES ('5346477687', 3, '234234234423423', 534, 1);
INSERT INTO tb_pagamento(cpf_cnpj, metodo_pagamento, num_cartao, valor, status_id) VALUES ('1092302234', 4, '423424234234242', 342, 3);