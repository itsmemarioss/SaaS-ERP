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

This project approaches the development of fundamental architecture for a SaaS
application following the model multi-tenant, where several clients use the same
application’s instance sharing resources of software and hardware. For support a
multi-tenant system was chosen as architecture of data base a model with greater
sharing, shared schemas. The application was built having as scope the commercial
use, it is important say that the application was not developed completely, it was
developed only enough functionalities to demonstrate the concepts of this project. It
was used Java 7 as programming language on the development of this application
and many specifications APIs from Java EE such as JSF and JPA that had great
importance in this project. EclipseLink was chosen to provide implementation for
JPA. It was used SpringSecutity to access control. As SMDB it was chose the
PostgreSQL 9.3. The development of the project was guided by good practices such
as General Responsibility Assignment Software Patterns and Design Patterns to
grant high quality in final result and provide an easy system to maintain and evolve.

**Key Words:** Multi-tenant. Software as a Service. Java Persistence API.
