package dao;

import beans.UsuarioBean;
import dao.interfaces.UsuarioDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Esta classe possibilita a manipulação dos dados de usuários
 * no banco de dados
 */
public class MySQLUsuarioDAO implements UsuarioDAO
{
   private Session session;

   /**
    * Este método faz a busca de um usuário no sistema
    * @param usuario O JavaBean contendo os dados de busca (login) do usuário
    * @return Um JavaBean UsuarioBean contendo os dados do usuário buscado
    */
    public UsuarioBean buscarUsuario(UsuarioBean usuario) throws Exception
    {
      if(usuario == null)
        throw new Exception("O parâmetro é nulo");

      session = MySQLAgendaDAOFactory.getInstance();
      Query q = session.createQuery("select u from UsuarioBean u where u.login = ? and u.senha = ?");
      q.setString(0, usuario.getLogin());
      q.setString(1, usuario.getSenha());
      List l = q.list();
      if (!l.isEmpty())
      {
        usuario = (UsuarioBean)q.list().get(0);
        return usuario;
      }
      return null;
    }
}
