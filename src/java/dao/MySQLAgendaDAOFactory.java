package dao;

import dao.interfaces.ContatoDAO;
import dao.interfaces.UsuarioDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Esta classe gerencia conexões com o banco de dados da agenda
 */
public class MySQLAgendaDAOFactory
{
  private static final SessionFactory sessionFactory; //A fábrica de sessões para as conexões dos usuários com o banco
  //Thread utilizada para executar a sessão do usuário concorrentemente a outras threads
  private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

  static {
      try
      {
        //Configura a fábrica de conexões para obter os dados da conexão a partir do arquivo hibernate.cfg.xml
        sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
      }
      catch(Throwable ex)
      {
        throw new ExceptionInInitializerError(ex);
      }
  }

  /**
   * Esta função cria uma sessão para o usuário e a retorna
   * @return A sessão do usuário que permitirá o acesso ao banco de dados
   */
  public static Session getInstance()
  {
    Session session = (Session) threadLocal.get();
    session = sessionFactory.openSession();
    threadLocal.set(session);
    return session;
  }

    /**
     * Esta função retorna uma instância de um objeto da classe
     * MySQLUsuarioDAO, que implementa a interface UsuarioDAO.
     * @return um objeto da classe MySQLUsuarioDAO, que implementa a interface UsuarioDAO.
     */
    public static UsuarioDAO getUsuarioDAO() throws Exception
    {
       return new MySQLUsuarioDAO();
    }

    /**
     * Esta função retorna uma instância de um objeto da classe
     * MySQLContatoDAO, que implementa a interface ContatoDAO.
     * @return um objeto da classe MySQLContatoDAO, que implementa a interface ContatoDAO.
     */
    public static ContatoDAO getContatoDAO() throws Exception
    {
       return new MySQLContatoDAO();
    }
}
