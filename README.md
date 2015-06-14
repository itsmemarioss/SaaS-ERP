# SaaS-ERP

Esse trabalho aborda o desenvolvimento da arquitetura fundamental de um sistema
SaaS seguindo o modelo multi-tenant, onde vários clientes usam a mesma instância
da aplicação compartilhando recursos de software e hardware. Como arquitetura do
banco de dados para suportar um sistema multi-tenant, optou-se por uma
abordagem de maior compartilhamento com banco de dados e esquema
compartilhados. A aplicação em questão foi construída tendo como escopo o uso
comercial, contudo vale ressaltar que a aplicação não foi desenvolvida com todas as
funcionalidades necessárias para o uso desse nicho de mercado e apenas com o
suficiente para demonstrar os conceitos envolvidos no projeto. Para
desenvolvimento dessa aplicação foi utilizado como linguagem de programação
Java 7 e várias APIs da especificação Java EE como JSF e o JPA que teve um
papel fundamental no desenvolvimento, tendo como implementação escolhida o
EclipseLink. Foi usado ainda o SpringSecurity para controle de acesso ao aplicativo.
Como gerenciador de banco de dados foi utilizado o PostgreSQL na versão 9.3. O
desenvolvimento do projeto foi guiado por boas práticas de atribuição de
responsabilidades a objetos de software e padrões de projeto a fim de garantir maior
qualidade no resultado final e proporcionar um sistema que seja possível evoluir de
forma mais fácil.

**Palavras-Chave:** Multi-tenant. Software as a Service. Java Persistence API.
