
package nus.iss.SA40.team9.EJB;
import nus.iss.SA40.team9.Model.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
@Stateless
public class UserBean {
    
    @PersistenceContext private EntityManager em;
    
    public boolean AddUser(Users user){
        boolean flag = false;
        System.out.println(user.toString());
        Users utest  = em.find(Users.class,user.getAccountName());
        if(utest != null)
        {
            return flag;
        }
        else{
            flag = true;
             //System.out.println("0136003");
             em.persist(user);
        }
        return flag;
        }
    
    
    public Users findUsers(String AccountName){
        return(em.find(Users.class, AccountName));
    }
    
    public boolean userLogin(String acctname, String passwd){
        boolean flag = true;
        //System.out.println("myfalse22");
        try {
            //System.out.println("myfalse");
        TypedQuery<Users> namedQuery = em.createNamedQuery("Users.findByAccountName", Users.class);
        
        namedQuery.setParameter("accountName", acctname);
        
        String val = namedQuery.getSingleResult().getPassword();
        if(val.equalsIgnoreCase(passwd)){
           // System.out.println("1");
            return flag;
        }
        else{
           // System.out.println("2");
            flag = false;
            return flag;
        }
        } 
        catch (Exception e) {
            flag = false;
            return flag;
        }
    }
}
