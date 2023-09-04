import java.util.ArrayList;
import java.util.List;

class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Aluno extends Pessoa {
    private String curso;

    public Aluno(String nome, String curso) {
        super(nome);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }
}

class Professor extends Pessoa {
    private String disciplina;

    public Professor(String nome, String disciplina) {
        super(nome);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }
}

class Curso {
    private String nome;
    private List<Disciplina> disciplinas;

    public Curso(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}

class Disciplina {
    private String nome;

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Turma {
    private Professor professor;
    private Disciplina disciplina;
    private List<Aluno> alunos;

    public Turma(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
    }

    public Professor getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}

class Ensalamento {
    public static void ensalarTurma(Turma turma) {
        System.out.println("Turma ensalada com sucesso:");
        System.out.println("Professor: " + turma.getProfessor().getNome());
        System.out.println("Disciplina: " + turma.getDisciplina().getNome());
        System.out.println("Alunos matriculados:");
        for (Aluno aluno : turma.getAlunos()) {
            System.out.println("- " + aluno.getNome() + " (Curso: " + aluno.getCurso() + ")");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Criação dos objetos Aluno
        Aluno[] alunos = {
                new Aluno("Alfredo", "TI"),
                new Aluno("Peterson", "ADM"),
                new Aluno("Wendel", "TI"),
                new Aluno("Ian", "ADM"),
                new Aluno("Debra", "TI"),
                new Aluno("Luana", "ADM"),
                new Aluno("Bruno", "TI"),
                new Aluno("Romeu", "ADM"),
                new Aluno("Julieta", "TI"),
                new Aluno("Maria", "ADM"),
                new Aluno("Capitú", "TI"),
                new Aluno("Bentinho", "ADM"),
                new Aluno("Amélia", "TI")
        };

        // Criação dos objetos Professor
        Professor[] professores = {
                new Professor("Mia", "POO"),
                new Professor("Saulo", "Estrutura de Dados"),
                new Professor("Paula", "BI")
        };

        // Criação dos objetos Curso
        Curso cursoTI = new Curso("TI");
        Curso cursoADM = new Curso("ADM");

        // Associação de Disciplinas aos Cursos
        cursoTI.adicionarDisciplina(new Disciplina("POO do curso de TI"));
        cursoTI.adicionarDisciplina(new Disciplina("Estrutura de Dados do curso de TI"));
        cursoADM.adicionarDisciplina(new Disciplina("BI do curso de ADM"));

        // Ensalamo uma turma
        Turma turma = new Turma(professores[0], cursoTI.getDisciplinas().get(0));
        turma.adicionarAluno(alunos[0]);
        turma.adicionarAluno(alunos[2]);
        turma.adicionarAluno(alunos[4]);

        Ensalamento.ensalarTurma(turma);
    }
}
