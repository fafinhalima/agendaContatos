package beans;

import dao.MySQLAgendaDAOFactory;
import dao.interfaces.UsuarioDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioBean implements Serializable
{
    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginUsuario")
    private Collection<ContatoBean> contatoCollection;

    /**
     * Usado para tratar o login do usuário
     * @return sucesso se o login for bem sucedido e falha caso contrário
     */
    public String onLogin()
    {
       UsuarioDAO usuario;
       try
       {
         usuario = MySQLAgendaDAOFactory.getUsuarioDAO();
         UsuarioBean u = usuario.buscarUsuario(this);
         if(u != null)
           return "sucesso";
       } 
       catch (Exception ex)
       {
         System.err.println("Erro: " + ex.getMessage());
       }
       return "falha";
    }

    /**
     * Usado para tratar o logoff do usuário
     * @return sucesso Indica que o logoff foi realizado com sucesso
     */
    public String onLogoff()
    {
      return "logoff";
    }

    /**
     * Esta função retorna um DataModel contendo a lista de contatos do usuário
     * @return model A lista de contatos do usuário
     */
    public DataModel getContatos()
    {
       UsuarioDAO usuario;
       try
       {
         usuario = MySQLAgendaDAOFactory.getUsuarioDAO();
         UsuarioBean u = usuario.buscarUsuario(this);
         if(u != null)
         {
           DataModel model = new ListDataModel(new ArrayList(u.getContatoCollection()));
           return model;
         }
       }
       catch(Exception ex)
       {
         System.err.println("Erro: " + ex.getMessage());
       }
       return null;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the contatoCollection
     */
    public Collection<ContatoBean> getContatoCollection() {
        return contatoCollection;
    }

    /**
     * @param contatoCollection the contatoCollection to set
     */
    public void setContatoCollection(Collection<ContatoBean> contatoCollection) {
        this.contatoCollection = contatoCollection;
    }
}
