package dao.interfaces;

import beans.ContatoBean;

/**
 * Esta interface define os métodos utilizados na
 * manipulação de dados de contatos.
 */
public interface ContatoDAO
{
   /**
    * Este método faz a remoção de um contato da agenda
    * @param Contato O JavaBean contendo os dados do contato a ser removido
    * @return true se a remoção ocorrer com sucesso e false caso contrário
    */
    public boolean delete(ContatoBean contato) throws Exception;
}

