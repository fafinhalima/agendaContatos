package dao.interfaces;

import beans.UsuarioBean;

/**
 * Esta interface define os métodos utilizados na
 * manipulação de dados de usuários.
 */
public interface UsuarioDAO
{
   /**
    * Este método faz a busca de um usuário no sistema
    * @param usuario O JavaBean contendo os dados de busca (login) do usuário
    * @return Um JavaBean UsuarioBean contendo os dados do usuário buscado
    */
    public UsuarioBean buscarUsuario(UsuarioBean usuario) throws Exception;
}

