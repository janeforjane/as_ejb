package edu.ejb;

import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class EJBComponentImpl implements EJBComponent {

    private String login = "user";
    private String password = "user";
    public boolean authorized = false;
    private int countOfInputs = 0;
    private RandomPrediction randomPrediction = new RandomPrediction();


    private void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    private void setCountOfInputs(int countOfInputs) {
        this.countOfInputs = countOfInputs;
    }


    @Override
    public boolean login(String l, String p) {
        if (this.login.equals(l) && this.password.equals(p)) {

            setAuthorized(true);
            return true;

        } else {
            return false;
        }
    }

    @Override
//    @RolesAllowed({"r1", "r2"})
    public String getMessage() throws Exception {
        if (authorized) {
            if (countOfInputs <= 1) {
                countOfInputs++;
            } else {
                setCountOfInputs(0);
                setAuthorized(false);
            }
        }else {
            throw new Exception("some message");
        }


        return randomPrediction.getMessage();
//        return "Wow wow wow";
    }
}
