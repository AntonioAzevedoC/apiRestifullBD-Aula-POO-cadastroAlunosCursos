Você deverá implementar uma API REST em Java com Spring Boot que permita o gerenciamento de alunos e seus respectivos cursos.

A aplicação deve seguir os princípios trabalhados em laboratório com as classes Produto e Categoria, incluindo:
Modelo de dados com JPA e relacionamento bidirecional
Repositórios com JpaRepository
Regras de negócio na camada Service
Endpoints REST na camada Controller

1. Entidade Curso
Atributos:
Long id
String nome
String area
Relacionamento:

Um curso pode ter vários alunos → @OneToMany(mappedBy = "curso")

Entidade Aluno
Atributos:
Long id
String nome
int idade
String email

Relacionamento:
Um aluno pertence a apenas um curso → @ManyToOne
Relacionamento
Um curso possui vários alunos
Um aluno pertence a um curso

Requisitos funcionais
Implemente:
Repositórios para Aluno e Curso com JpaRepository

Serviços com os métodos:
Listar todos
Adicionar novo
Atualizar existente
Remover por id

Controllers com os respectivos endpoints REST (GET, POST, PUT, DELETE)

Exemplo de JSON para cadastrar um aluno
{
  "nome": "João Silva",   "idade": 22,   "email": "joao@email.com",   "curso": {     "id": 1   } }
O id da curso deve existir previamente no banco de dados.
