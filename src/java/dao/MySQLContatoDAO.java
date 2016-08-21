package dao;

import beans.ContatoBean;
import dao.interfaces.ContatoDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Esta classe possibilita a manipulação dos dados de contatos
 * no banco de dados
 */
public class MySQLContatoDAO implements ContatoDAO
{
   private Session session;

   /**
    * Este método faz a remoção de um contato da agenda
    * @param Contato O JavaBean contendo os dados do contato a ser removido
    * @return true se a remoção ocorrer com sucesso e false caso contrário
    */
    public boolean delete(ContatoBean contato) throws Exception
    {
      if(contato == null)
        throw new Exception("O parâmetro é nulo");

      session = MySQLAgendaDAOFactory.getInstance();
      Transaction tx = null;
      try
      {
        tx = session.beginTransaction();
        session.delete(contato);
        tx.commit();
        return true;
      }
      catch(HibernateException ex)
      {
        ex.printStackTrace();
        tx.rollback(); //Desfaz a operação de remoção
      }
      finally
      {
        session.close();
      }
      return false;
    }
}
