package shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    private String clientFirstName;
    private String clientSurname;
    private String clientAddress;
    private String clientSex;
    private Integer clientPesel;
    private Integer clientAge;



    public Client() {
    }

    public Client(String clientFirstName, String clientSurname, String clientAddress, String clientSex, Integer clientPesel, Integer clientAge) {
        this.clientFirstName = clientFirstName;
        this.clientSurname = clientSurname;
        this.clientAddress = clientAddress;
        this.clientSex = clientSex;
        this.clientPesel = clientPesel;
        this.clientAge = clientAge;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientSex() {
        return clientSex;
    }

    public void setClientSex(String clientSex) {
        this.clientSex = clientSex;
    }

    public Integer getClientPesel() {
        return clientPesel;
    }

    public void setClientPesel(Integer clientPesel) {
        this.clientPesel = clientPesel;
    }

    public Integer getClientAge() {
        return clientAge;
    }

    public void setClientAge(Integer clientAge) {
        this.clientAge = clientAge;
    }
}
