import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    public static void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS tarefas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                descricao TEXT NOT NULL,
                status TEXT DEFAULT 'Pendente'
            );
        """;

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.execute();
            System.out.println("Tabela verificada/criada com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public static void inserir(String texto) {
        String sql = "INSERT INTO tarefas(descricao) VALUES(?)";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, texto);
            pstmt.executeUpdate();
            System.out.println("Tarefa salva com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public static List<Tarefa> listar() {
        List<Tarefa> lista = new ArrayList<>();
        String sql = "SELECT id, descricao, status FROM tarefas";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Tarefa(
                    rs.getInt("id"),
                    rs.getString("descricao"),
                    rs.getString("status")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    public static void concluir(int id) {
        String sql = "UPDATE tarefas SET status = 'Concluída' WHERE id = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int linhas = pstmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Tarefa marcada como concluída!");
            } else {
                System.out.println("Nenhuma tarefa encontrada com esse ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public static void remover(int id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int linhas = pstmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Tarefa removida com sucesso!");
            } else {
                System.out.println("Nenhuma tarefa encontrada com esse ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover: " + e.getMessage());
        }
    }
}
