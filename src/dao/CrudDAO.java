package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Contrato comum para operações CRUD dos DAOs da aplicação.
 * Cada DAO concreto define o mapeamento da entidade para o esquema do banco.
 */
public interface CrudDAO<T, ID> {
    T inserir(T entidade) throws SQLException;

    Optional<T> buscarPorId(ID id) throws SQLException;

    List<T> listarTodos() throws SQLException;

    void atualizar(T entidade) throws SQLException;

    void excluir(ID id) throws SQLException;
}