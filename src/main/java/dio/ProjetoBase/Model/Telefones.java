package dio.ProjetoBase.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Telefones")
public class Telefones {

    @Id
    private String Telefone;
    private String DDD;
   


    public String getDDD() {
        return DDD;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }
}
